#!/bin/bash
# Base Variables
JENKINS_1=<ip>:<port>/jenkins
SECRET=`cat jenkins_secret`  # Adjust to proper secret path / API TOken
PROJECT=<project name>
JOB=<name of the job>

# List jenkins plugins
curl -sSL "http://$SECRET@$JENKINS_1/view/$PROJECT/job/$JOB/config.xml"  | 
	grep -hPo 'plugin="\K[^"]*' | 
	sort --ignore-case | 
	uniq
echo
