<?php namespace atlas;
require_once(__DIR__ . '/errors.php');

class storage{
  //
  function __construct($e) {
    $this->home = __DIR__;
    $this->errors = $e;
  }
  function constructPathFromArray($items){
    return $this->home . DIRECTORY_SEPARATOR . implode(DIRECTORY_SEPARATOR, $items);
  }
  //
  function constructPath(){
    return $this->constructPathFromArray(func_get_args());
  }
  //
  function getFileContent($path){
    return file_get_contents($path);
  }
}

?>