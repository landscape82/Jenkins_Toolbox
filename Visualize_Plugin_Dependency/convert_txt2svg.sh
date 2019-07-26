#!/bin/bash
# Base Variables
BIN_CHECK=dot
INPUT=plugins.txt
OUTPUT=plugins.svg

# Defined Functions
usage () {
    echo -e "Provide input and oputput file in following way: \n\t $0 $INPUT $OUTPUT"
}

if ! [ -x "$(command -v $BIN_CHECK)" ]; 
    then
        echo -e "Error: \n\t Command '$BIN_CHECK' not found, but can be installed with: \n\t sudo apt install ansible" 2>&1
        exit 1
    else
        echo "Check for installed - $BIN_CHECK - passed"
        if [ $# -ne 2 ]; then
            usage
            echo -e "Provide input and oputput file in following way: \n\t $0 $INPUT $OUTPUT"
            exit 1
        else
            echo error
        fi
fi


#dot -Tsvg  plugins.txt > plugins.svg
