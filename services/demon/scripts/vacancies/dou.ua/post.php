<?php
require_once(__DIR__.'/../../simple_html_dom.php');
require_once(__DIR__.'/../../context.php');

/*
 *  Extract companies from html page
 * post.php /path/to/data/folder
 */

$cntx = new \attlas\context(__DIR__);
if (count($argv) === 2){
  $cntxData = new \attlas\context($argv[1]);
  //
  $f = 'dou.html';
  $cntx->logger->echoLn("[+] Start processing {$f}");
  $rowHtml = $cntx->storage->getFileContent(array(), $f, false);
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
  $cntx->logger->echoLn("Invalid count of parameters");
}

?>