<?php namespace attlas;
require_once(__DIR__ . '/logger.php');
require_once(__DIR__ . '/errors.php');
require_once(__DIR__ . '/http.php');
require_once(__DIR__ . '/storage.php');

class context{
  //
  function __construct($h = null, $torHost = '127.0.0.1', $torPort = '9050') {
    $this->logger = new \attlas\logger();
    $this->errors = new \attlas\errors($this->logger);
    $this->http = new \attlas\http($this->errors, new \attlas\tor($this->logger, $torHost, $torPort));
    $this->storage = new \attlas\storage($h, $this->errors);
  }
  //
  function exit($status, $message, $data) {
    exit(json_encode((object)array('status' => $status, 'message' => $message, 'data' => $data)));
  }
}

/*/
$cntx = new \attlas\context();
$cntx->http->tor->test();
//var_dump($cntx);

//$cntx->logger->echo('a')->echoLn('b')->echo('c');
//var_dump($cntx->http->getJson('https://jobs.dou.ua/companies/fdbfjbf/vacancies/export/'));

//$cntx->logger->echoLn($cntx->storage->constructPath('.docs', 'attlas', 'dou.html'));
/*/
?>