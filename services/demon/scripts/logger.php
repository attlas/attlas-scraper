<?php namespace attlas;
class logger{
  //
  function __construct() {
  }

  function echo($text) {
    echo $text;
    return $this;
  }
  function tick() {
    return $this->echo('.');
  }
  function echoLn($text='') {
    $this->echo($text . PHP_EOL);
    return $this;
  }

}
?>