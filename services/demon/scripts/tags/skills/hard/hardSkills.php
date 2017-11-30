<?php namespace atlas;
require_once(__DIR__.'/../../../context.php');
require_once(__DIR__.'/../../../comparator.php');

class hardSkills{
  //
  function __construct() {
    //
    $this->cntx = new \atlas\context(__DIR__);
    $this->comp = new \atlas\comparator(($this->cntx->storage->getFileContent(array(), 'attrs.json', true))->tags);
  }
  //
  function grep($text){
    return $this->comp->grepTagsFromText($text);
  }
}
?>