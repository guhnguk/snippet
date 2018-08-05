#!/usr/bin/env bash

count=`ls -latrh part-r-00001_* | awk '{print $9}' | wc -l`
file=`ls -latrh part-r-00001_* | awk '{print $9}'`

#echo $count
#echo $file

array=( $file )
elements=${#array[@]}

#echo ${array[${i}]}
for ((i=0; i<elements; i++))
do
	if [ $i -lt 10 ]
	then
		mkdir 0$i
		mv ${array[${i}]} 0$i
	else
		mkdir $i
		mv ${array[${i}]} $i
	fi
done

