<?php
dl("php_curl.dll");
include 'util.php';
//
cypher2neo4j("reset.cypher");
cypher2neo4j("skills.hard.cypher");
cypher2neo4j("skills.soft.cypher");
?>
