<?php
require_once(__DIR__.'/../../simple_html_dom.php');
require_once(__DIR__.'/../../context.php');

/*
  Extract companies from html page
*/
$cntx = new \atlas\context(__DIR__);
$cntx->logger->echoLn("Start processing ...");
$rowHtml = $cntx->storage->getFileContent($cntx->storage->constructPath('dou.html'));
$html = str_get_html($rowHtml);
$r = array();
if($html){
  foreach($html->find('.cn-a') as $element){
    $arr = explode("/", $element->href);
    array_pop($arr);
    $id = array_pop($arr);
    $r[] = (object)array("id" => $id);
  }
  $html->clear();
  unset($html);
} else { 
  $cntx->logger->echoLn("Parse error");
}
//print_r($r);
$cntx->storage->putFileContent($cntx->storage->constructPath('companies.json'), json_encode($r));
$cnt = count($r);
$cntx->logger->echoLn("Done, number of companies {$cnt}");
?>