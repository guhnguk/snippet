#!/usr/bin/env bash

#iconv -f cp949 -t UTF-8 text2convert.txt > converted.txt
iconv -f cp949 -t UTF-8 $1 > $1.change.txt
