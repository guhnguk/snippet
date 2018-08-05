#!/bin/sh

## watch ftp server process

pid=`ps -ef | grep -i proftpd | grep -v grep | awk '{print $2}'`

now=$(date +"%Y-%m-%d %H:%M")
echo "now : $now"

if [ -z "$pid" ]
then
        echo "starting proftpd"
        serivce proftpd start
else
        echo "proftpd is now running"
fi
