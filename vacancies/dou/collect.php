<?php
require_once(__DIR__.'/../../simple_html_dom.php');
require_once(__DIR__.'/../../context.php');

/*
  Extract companies from html page
*/
$cntx = new \atlas\context();


echo "Processing ...".PHP_EOL;
$rowHtml = file_get_contents(__DIR__."/dou.html");
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
  echo "Parse error";
}
//print_r($r);
file_put_contents(__DIR__."/companies.json", json_encode($r));
$cnt = count($r);
echo "Done, number of companies {$cnt}" . PHP_EOL;
?>