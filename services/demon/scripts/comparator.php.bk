<?php namespace atlas;
  class comparator{
    //
    function __construct() {
      global $atlas;
      //
      $this->atlas = $atlas;
      $this->hardSkills = json_decode( file_get_contents( __DIR__ . '/../../tags/data/skills.hard.json' ) );
      $this->preprocessedTags = array();
      $this->weightedTags = array();
    }
    //
    function grepTags(&$tags, &$text) {
      $r = array();
      $text_len = strlen($text);
      $dels = array(" ", ".", "!", "?", "/", "\\", ";", ",", "|", "\t");
      foreach( $tags as $t ) {
        $tag_len = strlen($t);
        $pos = stripos($text,$t); 
        if($pos!==false) {
          $p = $pos+$tag_len;
          if ( ($p>=$text_len) or in_array($text[$p], $dels)){
            $r[] = strtolower($t);
          }
        }
      }
      return $r;
    }
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
  }

/*
function matchStreams(&$stream1, &$stream2){
  global $atlas;
  $r = array();
  //
  $sh = json_decode( file_get_contents( $atlas->dataRoot."skills.hard.json" ) );
  //$ss = json_decode( file_get_contents( $atlas->dataRoot."skills.soft.json" ) );
  //
  foreach($stream1 as $s1){
    $row = array("id" => $s1->id, "result"=>array());
    //
    $arr1 = array();
    $t1 = '';
    if (getItemText($s1, $t1)){
      matchText($sh, $t1, $arr1);
    }
    $arr1_cnt = count($arr1);
    foreach($stream2 as $s2){
      $value = 0;
      if ($arr1_cnt){
        $arr2 = array();
        $t2 = '';
        if (getItemText($s2, $t2)){
          matchText($sh, $t2, $arr2);
        }
        $arr2_cnt = count($arr2);
        if ($arr2_cnt) {
          $intersect = array_intersect( $arr1, $arr2 );
          $value = floor( 1000 * count( $intersect ) / $arr1_cnt ) / 10;
        }
      }
      $row["result"][] = array("id"=>$s2->id, "value"=>$value);
    }
    $r[] = $row;
  }
  return $r;

}
  //--------------------------------------------------------------------------
  // match
  $app->map("/match", function() use ($app) {
    $msg = "";
    if ($app->request->isGet()){
    } else if ($app->request->isPost()){
      $r = array();
      //$p = $app->request->post();
      $msg = ERR_INVALID_JSON;
      //$p = json_decode(file_get_contents('php://input'));
      $p = json_decode($app->request->getBody());
      if ($p){
        try {
          $r = matchStreams($p->stream1, $p->stream2);
          exit(buildJsonResponseNoMsg(200, $r));
        } catch (Exception $e) {
          $msg = $e->getMessage();
        }
      }
    } else if ($app->request->isPut()){
    } else if ($app->request->isDelete()){
    }
    exit(buildJsonResponseNoMsg(400, $msg));
  })->via("GET", "POST", "PUT", "DELETE");
*/
?>