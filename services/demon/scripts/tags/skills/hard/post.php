<?php namespace attlas;
require_once(__DIR__.'/hardSkills.php');

$hs = new \attlas\hardSkills();
//
$cntxData = new \attlas\context('/opt/attlas/docs/vacancies/dou.ua/20171127');
$vs = $cntxData->storage->getFileContent(array(), 'epam-systems.json', true);
foreach($vs as $v) {
  $tags = $hs->grep($v->vacancy);
  $cntx->logger->echo(count($tags));
  $cntx->logger->echo(" ");
  foreach($tags as $t) {
    $cntx->logger->echo($t->tag . "|");
  }
  $cntx->logger->echoLn();
  $cntx->logger->echoLn();
}
//
/*/
print_r($comp->grepTagsFromText('abcjunitabc'));
print_r($comp->grepTagsFromText('abcjunit abc'));
print_r($comp->grepTagsFromText('abc junitabc'));
print_r($comp->grepTagsFromText(' junit '));
print_r($comp->grepTagsFromText('abc junit abc'));
/*/
/*/
var_dump($comp->grepTagsFromText(' •  3+ years` commercial Java experience; • AWS technology stack; • Spring technology stack; •  Hibernate/JPA; •  Experience with microservices architecture; • REST services; •  Experience with Oracle; • Familiarity with testing tools such as JUnit, Mockito, AssertJ, Spring-Test; •  Strong troubleshooting and debugging experience; •  Experience with *NIX systems; • Profound knowledge of Build Tools such as Maven or Gradle; •  Familiarity with CI/CD principles; •  Version Control: Git experience; •  Team player; •  English level: B2 or higher. •  Competitive compensation depending on experience and skills; •  Individual career path in engineering; • Social package — medical insurance, sports; •  Compensation for sick lists and regular vacations; •  English classes with certified English teachers. •  Design and implement tasks required to build (micro) services which would supply data to Eikon (desktop app); • Communicating with onsite representatives in scope of agile process; •  Follow clean code conventions.'));
/*/

?>