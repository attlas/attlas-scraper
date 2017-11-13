<?php namespace atlas;
require_once(__DIR__ . '/errors.php');

class storage{
  //
  function __construct($e) {
    $this->home = __DIR__;
    $this->errors = $e;
  }
  function constructPath($items){
    return $this->home . DIRECTORY_SEPARATOR . implode(DIRECTORY_SEPARATOR, $items);
  }
}

?>