<?php namespace atlas;
require_once(__DIR__ . '/logger.php');

class status{
  //
  function __construct() {
    $this->ret = false;
    $this->errCode = 0;
    $this->errMsg = '';
    $this->data = array();
  }
  function isOk() {
    return $this->ret;
  }
}

class errors{
  //
  function __construct($l) {
    $this->logger = $l;
  }
  //
  function createStatus() {
    return new \atlas\status();
  }
}
?>