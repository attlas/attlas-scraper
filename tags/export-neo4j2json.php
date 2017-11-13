<?php
dl("php_curl.dll");
include 'util.php';
//
neo4j2json( "skills.hard.json", array( "skill", "hard" ) );
neo4j2json( "skills.soft.json", array( "skill", "soft" ) );
//neo4j2json( "interests.json", array( "tag", "interest" ) );
//neo4j2json( "contact.json", array( "contact" ) );
?>
