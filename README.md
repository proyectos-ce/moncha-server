# Moncha server #
**MO**NCHA IS **N**OT **CH**EF **A**PP 
=======

## Requirements ##

 - Maven
 - Heroku-CLI (optional for deploying)
 - Tomcat 8
 - JDK 8

## Building ##

    $ mvn package

## Running the server ##

    $ java -jar target/dependency/webapp-runner.jar target/*.war

*The server will start in port 8080.*

## Deploying to Heroku ##

    $ mvn clean heroku:deploy-war
    
    
    
## Further reading ##

 - https://devcenter.heroku.com/articles/java-webapp-runner
 - https://devcenter.heroku.com/articles/deploying-java-applications-with-the-heroku-maven-plugin
