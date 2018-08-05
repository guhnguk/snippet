#!/usr/bin/env bash

for ((i = 0; i <= 19; i++)) 
do 
	if [ $i -lt 10 ]
	then
		find . -name part-r-0000$i | xargs wc -l >> result.txt
	else
		find . -name part-r-000$i | xargs wc -l >> result.txt
	fi
done

