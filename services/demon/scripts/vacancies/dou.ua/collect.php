<?php
require_once(__DIR__.'/../../simple_html_dom.php');
require_once(__DIR__.'/../../context.php');

/opt/attlas/docs/vacancies/dou.ua
/opt/attlas/docs/vacancies/dou.ua

/*
  Extract companies from html page
*/
$cntx = new \atlas\context(__DIR__);
$path = $cntx->storage->constructPath('dou.html');
$cntx->logger->echoLn("Start processing {$path}");
$rowHtml = $cntx->storage->getFileContent($path);
$html = str_get_html($rowHtml);
$r = array();
if($html){
  foreach($html->find('.cn-a') as $element){
    $arr = explode("/", $element->href);
    array_pop($arr);
    $id = array_pop($arr);
    $r[] = (object)array("id" => $id);
    $cntx->logger->tick();
  }
  $html->clear();
  unset($html);
  $cntx->logger->echoLn();
} else { 
  $cntx->logger->echoLn("Parse error");
}
//print_r($r);
$cntx->storage->putFileContent($cntx->storage->constructPath('dou.json'), json_encode($r));
$cnt = count($r);
$cntx->logger->echoLn("Done, number of companies {$cnt}");
?>