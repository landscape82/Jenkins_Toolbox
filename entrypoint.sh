#!/bin/bash

CLI=jenkins-cli.jar
SECRET=jenkins_secret

java -jar $CLI -s http://<ip>:<port>/jenkins -auth @jenkins_secret groovy = < $@
