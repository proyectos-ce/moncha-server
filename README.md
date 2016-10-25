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

*The server will start in port 8080.*

## Instructions for deploying to Heroku ##

    $ mvn clean heroku:deploy-war`
    
    
    
## Further resources ##

 - https://devcenter.heroku.com/articles/deploying-java-applications-with-the-heroku-maven-plugin
 - https://devcenter.heroku.com/articles/java-webapp-runner
 - https://devcenter.heroku.com/articles/deploying-java-applications-with-the-heroku-maven-plugin
