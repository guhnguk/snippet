#!/usr/bin/env python
#-*- coding: utf-8 -*-

a = 107
b = a & 0x0f
print(b)

print('-------------------------')
b = (a>>4) & 0x0f
print(b)