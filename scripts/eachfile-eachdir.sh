#!/usr/bin/env bash

for ((i = 0; i <=19; i++)) 
do
	if [ $i -lt 10 ]
	then
		mkdir 0$i
		mv part-r-0000$i 0$i
	else
		mkdir $i
		mv part-r-000$i $i
	fi
done
