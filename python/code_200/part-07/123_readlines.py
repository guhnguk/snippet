#!/usr/bin/env python3
# -*- coding: utf-8 -*-


f = open('stockcode.txt', 'r')
lines = f.readlines()
for line_num, line in enumerate(lines):
    print('%d %s' %(line_num+1, line), end='')

f.close()