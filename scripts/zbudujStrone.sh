#!/bin/sh

echo 
./scripts/glassfish3/glassfish/bin/asadmin undeploy dziennik
echo 
mvn package
echo 
./scripts/glassfish3/glassfish/bin/asadmin deploy target/dziennik.war
