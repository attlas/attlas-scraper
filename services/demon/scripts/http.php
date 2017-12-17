<?php namespace attlas;
require_once(__DIR__ . '/errors.php');
require_once(__DIR__ . '/httpCodes.php');
require_once(__DIR__ . '/tor.php');

class http{
  //
  function __construct($e, $tor) {
    $this->errors = $e;
    $this->tor = $tor;
  }
  //
  function getJson($url) {
    return $this->get($url, true);
  }

  function get($url, $decode, $useTor = false) {
    $c = curl_init();
    if ($useTor) {
      $this->tor->config($c, $url);
    } else {
      curl_setopt($c, CURLOPT_RETURNTRANSFER, true);
      curl_setopt($c, CURLOPT_SSL_VERIFYPEER, 0);
      //curl_setopt( $c, CURLOPT_HTTPHEADER, array( "Content-Type: application/json" ) );
      curl_setopt($c, CURLOPT_USERAGENT, 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36');
      curl_setopt($c, CURLOPT_IPRESOLVE, CURL_IPRESOLVE_V4);
      curl_setopt($c, CURLOPT_URL, $url);
      //curl_setopt( $c, CURLOPT_USERPWD, 'user:pass');
      curl_setopt($c, CURLOPT_POST, 0);
      //curl_setopt( $c, CURLOPT_POSTFIELDS, '{}' );
    }
    $cret   = curl_exec($c);
    //
    $status = $this->errors->createStatus();
    $status->ret = ($cret !== false);
    if ($status->isOk()) {
      if ($decode) {
        $status->data = json_decode($cret);
        if ($status->data === null){
          $status->ret = false;
          $status->errCode = 1000;
          $status->errMsg = 'Output is not a JSON';
        }
      } else {
        $status->data = $cret;
      }
    } else {
      $status->errCode = curl_errno($c);
      $status->errMsg = curl_error($c);
    }
    curl_close($c);
    return $status;
  }

}
?>