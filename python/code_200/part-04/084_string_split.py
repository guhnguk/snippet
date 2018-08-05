#!/usr/bin/env python3
# -*-coding: utf-8 -*-

url = 'http://www.naver.com/news/today=20170719'
log = 'name:Kris age:17 sex:남자 nation:대한민국'

ret1 = url.split('/')
print(ret1)

ret2 = log.split()
for data in ret2:
    d1, d2 = data.split(':')
    print('%s->%s' %(d1, d2))
