#!/usr/bin/env bash

#SERVERS=/home/hadoop/hadoop/hadoop/conf/slaves
#SERVERS=$HADOOP_HOME/conf/slaves
SERVERS=./slaves
if [ 2 -gt "$#" ]
then
	echo "usage: $0 \"<local full path> <remote full path>\""
	exit 1
fi

for i in `cat $SERVERS`
do
	scp "$1" $i:"$2"
done
