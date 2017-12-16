<?php
/* Export vacancies for set of companies
 */

require_once(__DIR__ . '/../../simple_html_dom.php');
require_once(__DIR__ . '/../../context.php');
require_once(__DIR__ . '/../../tags/skills/hard/hardSkills.php');

define('STATUS_FILE_NAME', 'export-status.json');


function parseVacancy($cntx, $url) {
  $details = (object)array(
    'vacancy' => '',
    'cities' => '',
    'log' => array()
  );
  //
  try {
    // parse vacancy html
    $statusVacHtml = $cntx->http->get($url, false, true);
    if ($statusVacHtml->isOk()){
      $rowHtml = $statusVacHtml->data;
      $html = str_get_html($rowHtml);
      if ($html) {
        // get vacancy details
        // TODO split into sections: description, requirements etc.
        foreach ($html->find('div.vacancy-section div p') as $element) {
          $details->vacancy .= ' ' . $element->plaintext;
        }
        // get vacancy location
        foreach ($html->find('span.place') as $element) {
          $details->cities .= trim($element->plaintext);
        }
        $html->clear();
        unset($html);
      } else {
        $details->log[] = $statusVacHtml->errMsg;
      }
    } else {
      $details->log[] = 'Parsing error: ' . $url;
    }
  }
  catch (Exception $e) {
    $details->log[] = $e->getMessage();
  }
  return $details;
}
//
/*
 * $cntx - context
 * $date - export  date
 * $listOfCompanies - 
 * $sleepTimeout - timeout in seconds between requests
 * $companiesLimit - number of campanies to be processed during sinle call
 */
function exportCompanies($cntx, $date, $listOfCompanies = array(), $sleepTimeout = 1, $companiesLimit = 10) {
  $key       = $date;
  //
  $r = (object) array(
    'timestamp' => $key,
    'totalCompanies' => 0,
    'processedCompanies' => 0,
    'processedVacancies' => 0,
    'executionTime' => microtime(true),
    'log' => array()
  );
  //
  $hs = new \attlas\hardSkills();
  //
  $companies = array();
  if (count($listOfCompanies)) {
    foreach ($listOfCompanies as $c) {
      $companies[] = (object)array('id' => $c);
    }
  } else {
    $companies = ($cntx->storage->getFileContent(array(), 'attrs.json', true))->companies;
  }
  //
  $r->totalCompanies = count($companies);
  foreach ($companies as $c) {
    //
    // check limit
    if ($r->processedCompanies >= $companiesLimit) {
      break;
    }
    $companyId = $c->id;
    $companyFileName = "{$companyId}.json";
    // skip if data was already imported
    if ($cntx->storage->fileExists(array($date), $companyFileName)) {
      continue;
    }
    $r->processedCompanies++;
    //
    // get all company vacancies
    $url  = "https://jobs.dou.ua/companies/{$companyId}/vacancies/export/";
    $r->log[] = "[{$r->processedCompanies}] Processing {$url}";
    $data = array();
    $status = $cntx->http->get($url, true, true);
    if ($status->isOk()) {
      $data = $status->data;
      if (count($data)) {
        foreach ($data as &$d) {
          $r->processedVacancies++;
          sleep($sleepTimeout);
          //
          // get more details from plain html
          $details = parseVacancy($cntx, $d->link);
          $r->log = array_merge($r->log, $details->log);
          //
          $d->vacancy = $details->vacancy;
          if (!empty($details->cities)) {
            $d->city = $details->cities;
          }
          //
          $d->tags = $hs->grep($details->vacancy);
        }
        //
      } else {
        $r->log[] = "No data";
      }
      if (count($data)) {
        $cntx->storage->putFileContent(array($date), $companyFileName, json_encode($data));
      }
    } else {
      $r->log[] = "Get data error, {$status->errMsg}";
    }
  }
  $r->executionTime = microtime(true) - $r->executionTime;
  //
  $exportStatus = $cntx->storage->getFileContent(array($key), STATUS_FILE_NAME, true);
  if (empty($exportStatus)){
    $exportStatus = array();
  }
  $exportStatus[] = $r;
  $cntx->storage->putFileContent(array($key),  STATUS_FILE_NAME, json_encode($exportStatus));
  return $r;
}
//
// nohup php export.php /opt/attlas/docs/vacancies/dou.ua 20171216 127.0.0.1 9050 &
$cntx = new \attlas\context(__DIR__);
if (count($argv) === 5){
  $data = exportCompanies(new \attlas\context($argv[1], $argv[3], $argv[4]), $argv[2]/*, array('globallogic', '1plus1')*/);
  $cntx->exit(\attlas\httpCodes::HTTP_OK, '', $data);
}
$cntx->exit(\attlas\httpCodes::HTTP_BAD_REQUEST, 'Invalid arguments', null);

?>