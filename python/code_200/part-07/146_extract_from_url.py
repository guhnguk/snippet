#!/usr/bin/env python3
# -*- coding: utf-8 -*-

url = 'http://news.naver.com/main/read.nhn?mode=LSD&mid=shm&sid1=105&oid=028&adi=0002334601'

tmp = url.split('/')
domain = tmp[2]
print(domain)

print('------------------')

tmp = url.split('?')
queries = tmp[1].split('&')
for query in queries:
    print(query)