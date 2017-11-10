<?php
  echo __DIR__;
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
  }
  print_r($r);
?>