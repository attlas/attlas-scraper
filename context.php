<?php namespace atlas;
require_once(__DIR__ . '/logger.php');
require_once(__DIR__ . '/errors.php');
require_once(__DIR__ . '/http.php');
require_once(__DIR__ . '/storage.php');

class context{
  //
  function __construct() {
    $this->logger = new \atlas\logger();
    $this->errors = new \atlas\errors($this->logger);
    $this->http = new \atlas\http($this->errors);
    $this->storage = new \atlas\storage($this->errors);
  }
}

$cntx = new \atlas\context();
//var_dump($cntx);

//$cntx->logger->echo('a')->echoLn('b')->echo('c');
//var_dump($cntx->http->getJson('https://jobs.dou.ua/companies/fdbfjbf/vacancies/export/'));

$cntx->logger->echoLn($cntx->storage->constructPath('.docs', 'attlas', 'dou.html'));
?>