#!/usr/bin/env python3
# -*- coding: utf-8 -*-


f = open('stockcode.txt', 'r')
h = open('stockcode_copy.text', 'w')

data = f.read()
h.write(data)

f.close()
h.close()