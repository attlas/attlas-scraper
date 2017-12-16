<?php namespace attlas;
require_once(__DIR__ . '/logger.php');

class tor{
  //
  function __construct($l, $host, $port) {
    $this->logger = $l;
    $this->host = $host;
    $this->port = $port;
  }
  //
  function config($curl, $url) {
    curl_setopt($curl, CURLOPT_USERAGENT,'Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.8.1.13) Gecko/20080311 Firefox/2.0.0.13');
    curl_setopt($curl, CURLOPT_URL, $url);
    curl_setopt($curl, CURLOPT_TIMEOUT, 60); 
    curl_setopt($curl, CURLOPT_HTTPGET, 1);
    curl_setopt($curl, CURLOPT_RETURNTRANSFER, TRUE);
    curl_setopt($curl, CURLOPT_PROXY, "{$this->host}:{$this->port}");
    curl_setopt($curl, CURLOPT_PROXYTYPE, CURLPROXY_SOCKS5);
    curl_setopt($curl, CURLOPT_FOLLOWLOCATION, TRUE);
  }
  //
  function get($url){
    $curl = curl_init();
    $this->config($curl, $url);
    $r = curl_exec($curl);
    curl_close($curl);
    return $r;
  }
  //
  function test(){
    //$this->logger->echoLn($this->get("http://whatismyip.org"));
    $this->logger->echoLn($this->get('https://ipinfo.io/json'));
    //$this->logger->echoLn($this->get("https://jobs.dou.ua/companies/epam-systems/vacancies/export/"));
  }

}

/*/
$t = new \attlas\tor(new \attlas\logger(), '127.0.0.1', '9050');
$t->test();
/*/

/*
$ip = '127.0.0.1';
$port = '9051';
$auth = 'PASSWORD';
$command = 'signal NEWNYM';
 
$fp = fsockopen($ip,$port,$error_number,$err_string,10);
if(!$fp) { echo "ERROR: $error_number : $err_string";
    return false;
} else {
    fwrite($fp,"AUTHENTICATE \"".$auth."\"\n");
    $received = fread($fp,512);
    fwrite($fp,$command."\n");
    $received = fread($fp,512);
}
 
fclose($fp);
 
$ch = curl_init();
curl_setopt($ch, CURLOPT_URL, "http://whatismyip.org");
curl_setopt($ch, CURLOPT_PROXY, "127.0.0.1:9050");
curl_setopt($ch, CURLOPT_PROXYTYPE, CURLPROXY_SOCKS5);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
curl_setopt($ch, CURLOPT_VERBOSE, 0);
$response = curl_exec($ch);
*/
?>