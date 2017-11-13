<?php
include 'util.php';

csv2cypher( "skills.hard.csv", "skills.hard.cypher", true, ":skill:hard", array( "other" ) );
csv2cypher( "skills.soft.csv", "skills.soft.cypher", true, ":skill:soft", array() );
?>