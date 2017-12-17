#!/bin/bash
/opt/neo4j-community-2.1.5/bin/neo4j-shell -file /var/www/html/data/out/delete.cypher
/opt/neo4j-community-2.1.5/bin/neo4j-shell -file /var/www/html/data/out/services.cypher
/opt/neo4j-community-2.1.5/bin/neo4j-shell -file /var/www/html/data/out/hspace.cypher
#/opt/neo4j-community-2.1.5/bin/neo4j-shell -file /var/www/html/data/out/gl.cypher
#/opt/neo4j-community-2.1.5/bin/neo4j-shell -file /var/www/html/data/out/malls.cypher
/opt/neo4j-community-2.1.5/bin/neo4j-shell -file /var/www/html/data/out/tag-skills-hard.cypher
/opt/neo4j-community-2.1.5/bin/neo4j-shell -file /var/www/html/data/out/tag-skills-soft.cypher
/opt/neo4j-community-2.1.5/bin/neo4j-shell -file /var/www/html/data/out/tag-interests.cypher
