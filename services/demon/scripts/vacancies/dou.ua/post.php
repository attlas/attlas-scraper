<?php
require_once(__DIR__.'/../../simple_html_dom.php');
require_once(__DIR__.'/../../context.php');

$cntx = new \atlas\context(__DIR__);
if (count($argv) === 2){
  $cntxData = new \atlas\context($argv[1]);
  //
  $f = 'dou.html';
  $cntx->logger->echoLn("[+] Start processing {$f}");
  $rowHtml = $cntx->storage->getFileContent(array(), $f);
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
  //
  $cntxData->storage->putFileContent(array(), 'attrs.json', json_encode((object)array('companies' => $r)));
  $cnt = count($r);
  $cntx->logger->echoLn("[-] Done, number of companies {$cnt}");
} else {
  $cntx->logger->echoLn("Invalid parameters count");
}

/*
  Extract companies from html page
*/
/*
//print_r($r);
$cntx->storage->putFileContent($cntx->storage->constructPath('dou.json'), json_encode($r));
*/
?>