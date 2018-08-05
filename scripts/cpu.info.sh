#!/usr/bin/env bash

# RYAN AHN

cpu=`grep "physical id" /proc/cpuinfo | sort -u | wc -l`
cores=`grep -c processor /proc/cpuinfo`
each_core=`grep "cpu cores" /proc/cpuinfo | tail -1`

CHIP_COUNT=`cat /proc/cpuinfo | grep "physical id" | sort -u | wc -l`
CHIP_CORES=`cat /proc/cpuinfo | grep "siblings" | tail -1 | cut -d: -f2` 

echo "The number of CPU  => $cpu"
echo "This system => $each_core"
echo "CPU: $CHIP_COUNT chips x $CHIP_CORES cores"
echo "The number of Cores based on hyperthreading => $cores"



