<?php namespace attlas;

class comparator{
  //
  function __construct($tags) {
    //
    $this->tags = $tags;
  }
  //
  function grepTagsFromText($text) {
    $r = array();
    $text_len = strlen($text);
    $dels = array(" ", ".", "!", "?", "/", "\\", ";", ",", "|", "\t");
    foreach($this->tags as $t) {
      $tag_len = strlen($t);
      $pos = stripos($text,$t); 
      if($pos!==false) {
        $p = $pos+$tag_len;
        // check if tag is not just subpart of other longer word
        if ((($p>=$text_len) or in_array($text[$p], $dels)) and (($pos==0) or in_array($text[$pos-1], $dels)) ){
          $r[] = (object)array('tag' => strtolower($t));
        }
      }
    }
    return $r;
  }
/*/
    //
    function matchTexts(&$text1, &$text2) {
      $value = 0;
      $arr1 = $this->grepTags($this->hardSkills, $text1);
      //
      if (count($arr1)){
        $arr2 = $this->grepTags($this->hardSkills, $text2);
        //
        if (count($arr2)) {
          $value = $this->matchTagArrs($arr1, $arr2);
        }
      }
      return $value;
    }
    //
    function preprocess(&$text){
      if (!empty($text)){
        $this->preprocessedTags = $this->grepTags($this->hardSkills, $text);
      }
      return $this;
    }
    function getPreprocessedTags(){
      return $this->preprocessedTags;
    }
    //
    function weighTags(){
      $tags = $this->getPreprocessedTags();
      foreach($tags as $t){
        if (empty($this->weightedTags[$t])){
          $this->weightedTags[$t] = (object)array("weight" => 1);
        }else{
          $this->weightedTags[$t]->weight++;
        }
      }
      return $this;
    }
    function sort(){
      uasort($this->weightedTags, function (&$l, &$r){
        return ($l->weight < $r->weight);
      });
      return $this;
    }
    function getWeightedTags(){
      return $this->weightedTags;
    }
    //
    function matchText(&$text){
      $value = 0;
      //
      if (count($this->preprocessedTags)){
        $arr2 = $this->grepTags($this->hardSkills, $text);
        //
        if (count($arr2)) {
          $value = $this->matchTagArrs($this->preprocessedTags, $arr2);
        }
      }
      return $value;
    }
    function matchTags(&$tags){
      $value = 0;
      if (count($this->preprocessedTags)){
          $value = $this->matchTagArrs($this->preprocessedTags, $tags);
      }
      return $value;
    }
    function matchTagArrs(&$tags1, &$tags2){
      $value = 0;
      $arr1_cnt = count($tags1);
      $arr2_cnt = count($tags2);
      if ($arr1_cnt && $arr2_cnt){
        $intersect = array_intersect($tags1, $tags2);
        $arr_cnt = count($intersect);
        $value = floor(1000 * ($arr_cnt / $arr1_cnt + $arr_cnt / $arr2_cnt ) / 2) / 10;
      }
      return $value;
    }
/*/
}
?>