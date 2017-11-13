<?php
require_once(__DIR__ . '/simple_html_dom.php');
require_once(__DIR__ . '/comparator.php');
require_once(__DIR__ . '/utils.php');

function processCompanies($dataHome, $date, $listOfCompanies=array())
{
  $key       = $date;
  $r         = (object) array(
    'timestamp' => $key,
    'companies' => 0,
    'vacancies' => 0,
    'executionTime' => microtime(true),
    'errors' => array()
  );
  //
  $cmp       = new \atlas\comparator();
  $companies = array();
  if (count($listOfCompanies)) {
    foreach ($listOfCompanies as $c) {
      $companies[] = (object)array('id' => $c);
    }
  } else {
    $companies = json_decode(file_get_contents(__DIR__ . '/companies.json'));
  }
  //
  $cCount = count($companies);
  $cI = 0;
  echoLn("Number of companies to process {$cCount}");
  foreach ($companies as $c) {
    //
    $id   = $c->id;
    $cI++;
    if ($cI > 2) {
      break;
    }
    // get all company vacancies
    $url  = "https://jobs.dou.ua/companies/{$id}/vacancies/export/";
    echoLn("[{$cI}] Processing {$url}");
    $data = array();
    if (get($url, $data)) {
      echoLn();
      print_r($data);
      echoLn();
      if (count($data)) {
        $r->companies++;
        echoLn(count($data) . '-> ', false);
        foreach ($data as &$d) {
          $r->vacancies++;
          // get vacancies details
          //echo $d->link.PHP_EOL;
          $vacancy = '';
          $cities  = "";
          try {
            // parce vacancy html
            $rowHtml = "";
            get($d->link, $rowHtml, false);
            $html = str_get_html($rowHtml);
            if ($html) {
              // get vacancy details
              // TODO split into sections: description, requirements etc.
              foreach ($html->find('div.vacancy-section div p') as $element) {
                $vacancy .= ' ' . $element->plaintext;
              }
              // get vacancy location
              foreach ($html->find('span.place') as $element) {
                $cities .= trim($element->plaintext);
              }
              
              $html->clear();
              unset($html);
            } else {
              $r->errors[] = 'parse error: ' . $d->link;
            }
          }
          catch (Exception $e) {
            $r->errors[] = $e->getMessage();
          }
          $d->vacancy = $vacancy;
          if (!empty($cities)) {
            $d->city = $cities;
          }
          $cmp->preprocess($vacancy);
          $d->tags = $cmp->getPreprocessedTags();
          echo '.';
        }
        //
      } else {
        $err = "No data for {$url}";
        echoLn($err); 
        $r->errors[] = $err;
      }
      $home = "{$dataHome}".DIRECTORY_SEPARATOR."{$date}";
      if (!file_exists($home)) {
        mkdir($home, 0777, true);
      }
      if (count($data)) {
        file_put_contents($home.DIRECTORY_SEPARATOR."${id}.json", json_encode($data));
      }
      echoLn(); 
      echoLn('done'); 
    } else {
      $err = "Get data error from {$url}";
      echoLn($err); 
      $r->errors[] = $err;
    }
  }
  $r->executionTime = microtime(true) - $r->executionTime;
  //
  return $r;
}
//
$options = getopt('h:d:c::');
if (count($options) >= 2){
  $home = $options['h'];
  $summary = processCompanies($home, $options['d'], explode(',', $options['c']));
  file_put_contents($home.DIRECTORY_SEPARATOR."summary.json", json_encode($summary));
} else {
  echoLn("Invalid arguments, try -h\"/path/to/data/home\" -d\"YYYYMMDD\"");
}


?>