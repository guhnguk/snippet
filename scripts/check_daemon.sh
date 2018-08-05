#!/usr/bin/env bash

PROCESS=process_name
COUNTER=1

while [ 1 ];do
    ps -ef | grep $PROCESS | grep -v grep 2>/dev/null >/dev/null
    if [ $? -eq 0 ];then
        echo "$PROCESS is started."
    else
        echo "$PROCESS is stopped."
    fi

    echo "COUNTER=$COUNTER "
    COUNTER=$(($COUNTER+1))

    if [ $COUNTER -gt 5 ];then
        break
    fi

    sleep 1

done
