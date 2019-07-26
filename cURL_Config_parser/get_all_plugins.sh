#!/bin/bash
# Base Variables
JENKINS_1=<jenkins instance ip>:8380/jenkins
SECRET=`cat jenkins_secret` # Adjust to proper secret path / API TOken

# List jenkins plugins
curl -sSL "http://$SECRET@$JENKINS_1/pluginManager/api/xml?depth=1&xpath=/*/*/shortName|/*/*/version&wrapper=plugins" | 
	perl -pe 's/.*?<shortName>([\w-]+).*?<version>([^<]+)()(<\/\w+>)+/\1 \2\n/g' |
	sed 's/ /:/' |
	sort --ignore-case
echo
