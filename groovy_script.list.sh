#!/bin/bash
#ls -l groovyScripts/ | awk -F' ' '{ print $9 }' | awk NF

listFunction () {
	ls -l groovyScripts/ | awk -F' ' '{ print $9 }'
	} 

echo "Category - ADMIN scripts:"
listFunction | grep ^admin | awk -vOFS="\t" '$0 { print "[" ++nr "]", $0; next } { print }' 
echo

echo "Category - JOB scripts:"
listFunction | grep ^job | awk -vOFS="\t" '$0 { print "[" ++nr "]", $0; next } { print }'
echo

echo "Category - MOCKUP scripts:"
listFunction | grep ^mockup | awk -vOFS="\t" '$0 { print "[" ++nr "]", $0; next } { print }'
echo

echo "Category - NODE scripts:"
listFunction | grep ^node | awk -vOFS="\t" '$0 { print "[" ++nr "]", $0; next } { print }'
echo

echo "Category - PLUGINS scripts:"
listFunction | grep ^plugins | awk -vOFS="\t" '$0 { print "[" ++nr "]", $0; next } { print }'
echo

echo "Category - PROJECTS scripts:"
listFunction | grep ^project | awk -vOFS="\t" '$0 { print "[" ++nr "]", $0; next } { print }'
echo


echo "Category - VIEW scripts:"
listFunction | grep ^view | awk -vOFS="\t" '$0 { print "[" ++nr "]", $0; next } { print }'
echo
