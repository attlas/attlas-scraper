<?php namespace atlas;
require_once(__DIR__ . '/errors.php');

class storage{
  //
  function __construct($h, $e) {
    $this->home = $h;
    if (empty($this->home)) {
      $this->home = __DIR__;
    }
    $this->errors = $e;
  }
  function constructPathFromArray($folders){
    $p = $this->home;
    if (count($folders)){
      $p .= DIRECTORY_SEPARATOR . implode(DIRECTORY_SEPARATOR, $folders);
    }
    return $p;
  }
  //
  function constructPath(){
    return $this->constructPathFromArray(func_get_args());
  }
  //
  function getFileContent($folders, $file, $decode){
    $data = file_get_contents($this->constructPathFromArray($folders) . DIRECTORY_SEPARATOR . $file);
    if ($decode) {
      return json_decode($data);
    }
    return $data;
  }
  //
  function putFileContent($folders, $file, $content){
    $p = $this->constructPathFromArray($folders);
    if (!file_exists($p)) {
      mkdir($p, 0644, true);
    }
    file_put_contents($p . DIRECTORY_SEPARATOR . $file, $content);
  }
}

?>