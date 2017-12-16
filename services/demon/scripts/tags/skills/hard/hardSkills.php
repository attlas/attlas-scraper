<?php namespace attlas;
require_once(__DIR__.'/../../../context.php');
require_once(__DIR__.'/../../../comparator.php');

class hardSkills{
  //
  function __construct() {
    //
    $this->cntx = new \attlas\context(__DIR__);
    $this->comp = new \attlas\comparator(($this->cntx->storage->getFileContent(array(), 'attrs.json', true))->tags);
  }
  //
  function grep($text){
    return $this->comp->grepTagsFromText($text);
  }
}
?>