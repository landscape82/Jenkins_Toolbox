#!/bin/bash

# Base Variables:
PORT=<port>
CLI=jenkins-cli.jar

# Directory Names:
Jenkins1_DIR=jenkins1
Jenkins2_DIR=jenkins2

# IP Addresses to Jenkins instances:
Jenkins1_URL=150.151.145.203 #URL with FQDN risk-jenkins.misys.global.ad
Jenkins2_URL=10.21.17.2 #URL with bm-ci-pl.misys.global.ad

# Encapsulated commands:
CHECK_DIR_Jenkins1=`ls | grep $Jenkins1_DIR`
CHECK_DIR_Jenkins2=`ls | grep $Jenkins2_DIR`

# Defined Functions
repeat () {
    printf '=%.0s' {1..74}; echo # Print line
}

case $@ in
  '--jenkins risk')
    echo "Creating directory for - RISK Jenkins CLI (risk-jenkins.misys.global.ad)"
    repeat
    mkdir $Jenkins1_DIR 2>/dev/null
        if [ -d jenkins1 ]; then 
      echo "Directory '$CHECK_DIR_Jenkins1' created!" 
      #rm -rf $CMR_DIR
      echo "Proceeding with downloading CLI"
      wget --output-document=$Jenkins1_DIR/$CLI http://$<ip:<port>/jenkins/jnlpJars/$CLI 2>/dev/null
      if [ -f "$Jenkins1_DIR/$CLI" ]; then
	      echo "$CLI found... Changing permissions..."
        chmod 511 $Jenkins1_DIR/$CLI
        echo ""
        echo "CLI is available in following location:"
        echo $PWD/$Jenkins1_DIR/$CLI
        else
	      echo "$CLI not found..."
      fi
    else
      echo "!!! Failure - Something isn't right... figure out by your own!"
    fi
  ;;
  
  '--jenkins bmci')
    echo "Creating directory for - BM-CI-PL Jenkins CLI (bm-ci-pl.misys.global.ad)"
    repeat
    mkdir $PL_DIR 2>/dev/null
        if [ -d jenkins2 ]; then 
      echo "Directory '$CHECK_DIR_Jenkins2' created!" 
      #rm -rf $CHECK_DIR_BPL
      echo "Proceeding with downloading CLI"
      wget --output-document=$Jenkins2_DIR/$CLI http://<ip>:<port>/jenkins/jnlpJars/$CLI 2>/dev/null
      if [ -f "$Jenkins2_DIR/$CLI" ]; then
	      echo "$CLI found... Changing permissions..."
        chmod 511 $Jenkins2_DIR/$CLI
        echo ""
        echo "CLI is available in following location:"
        echo $PWD/$Jenkins2_DIR/$CLI     
        else
	      echo "$CLI not found..."
      fi
    else
      echo "!!! Failure - Something isn't right... figure out by your own!"
    fi    
  ;;

  --help|-h|--usage|-u)
    echo "Type :
    '$0 --jenkins jenkins1' for download Jenkins 1 CLI...
    '$0 --jenkins jenkins2' for download Jenkins 2 CLI..."
  ;;
  
  *)
    echo "Provide some arguments... or add flag: --help"
    #...
  ;;
esac
