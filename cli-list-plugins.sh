#!/bin/bash
java -jar jenkins-cli.jar -s http://<ip>:<port>/jenkins -auth @jenkins_secret list-plugins
