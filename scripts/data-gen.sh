#!/usr/bin/env bash

Yesterday=`date --date='yesterday' +'%Y%m%d'`
Today=`date +'%Y%m%d'`
Tomorrow=`date --date='tomorrow' +'%Y%m%d'`

echo $Yesterday
echo $Today
echo $Tomorrow

Hour=`date +'%H'`
echo $Hour

#/home/hadoop/hadoop/bin/hadoop fs -mv 



