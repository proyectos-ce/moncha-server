# Moncha server
=======
**MO**NCHA IS **N**OT **CH**EF **A**PP 

## Requirements ##

 - Maven
 - Heroku-CLI (optional for deploying)
 - Tomcat 8
 - JDK 8

## Instructions for building ##

    $ mvn package

## Instructions for running the server ##

    $ java -jar target/dependency/webapp-runner.jar target/*.war

## Instructions for deploying to Heroku ##

`$ mvn clean heroku:deploy-war`
