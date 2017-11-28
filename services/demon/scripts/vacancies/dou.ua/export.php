<?php
require_once(__DIR__ . '/../../simple_html_dom.php');
require_once(__DIR__ . '/../../comparator.php');
require_once(__DIR__ . '/../../context.php');

//
/*
 * $cntx - context
 * $date - export  date
 * $listOfCompanies - 
 */
function exportCompanies($cntx, $date, $listOfCompanies = array()) {
  $key       = $date;
  $r         = (object) array(
    'timestamp' => $key,
    'companies' => 0,
    'vacancies' => 0,
    'executionTime' => microtime(true),
    'log' => array()
  );
  /*/
  $cmp       = new \atlas\comparator();
  /*/
  $companies = array();
  if (count($listOfCompanies)) {
    foreach ($listOfCompanies as $c) {
      $companies[] = (object)array('id' => $c);
    }
  } else {
    $companies = ($cntx->storage->getFileContent(array(), 'attrs.json', true))->companies;
  }
  //
  $cCount = count($companies);
  $cI = 0;
  $r->log[] = "Number of companies to process {$cCount}";
  foreach ($companies as $c) {
    //
    $id   = $c->id;
    $cI++;
    /*/
    if ($cI > 2) {
      break;
    }
    /*/
    // get all company vacancies
    $url  = "https://jobs.dou.ua/companies/{$id}/vacancies/export/";
    $r->log[] = "[{$cI}] Processing {$url}";
    $data = array();
    $status = $cntx->http->get($url, true);
    if ($status->isOk()) {
      echo $url . PHP_EOL;
      $data = $status->data;
      if (count($data)) {
        $r->companies++;
        foreach ($data as &$d) {
          $r->vacancies++;
          // get vacancies details
          //echo $d->link.PHP_EOL;
          $vacancy = '';
          $cities  = "";
          try {
            // parce vacancy html
            //
            $statusVacHtml = $cntx->http->get($d->link, false);
            if ($statusVacHtml->isOk()){
              $rowHtml = $statusVacHtml->data;
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
                $r->log[] = $statusVacHtml->errMsg;
              }
            } else {
              $r->log[] = 'parse error: ' . $d->link;
            }
            //
          }
          catch (Exception $e) {
            $r->log[] = $e->getMessage();
          }
          $d->vacancy = $vacancy;
          if (!empty($cities)) {
            $d->city = $cities;
          }
          /*/
          $cmp->preprocess($vacancy);
          $d->tags = $cmp->getPreprocessedTags();
          /*/
        }
        //
      } else {
        $r->log[] = "No data";
      }
      if (count($data)) {
        $cntx->storage->putFileContent(array($date), "${id}.json", json_encode($data));
      }
    } else {
      $r->log[] = "Get data error, {$status->errMsg}";
    }
  }
  $r->executionTime = microtime(true) - $r->executionTime;
  //
  $cntx->storage->putFileContent(array($date), "export-status.json", json_encode($r));  
  return $r;
}
//
$cntx = new \atlas\context(__DIR__);
if (count($argv) === 3){
  $cntxData = new \atlas\context($argv[1]);
  $data = exportCompanies($cntxData, $argv[2]);
  $cntx->exit(\atlas\httpCodes::HTTP_OK, '', $data);
}
$cntx->exit(\atlas\httpCodes::HTTP_BAD_REQUEST, 'Invalid arguments', null);

?>