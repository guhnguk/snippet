#!/usr/bin/env python3
# -*- coding: utf-8 -*-


text = input('파일에 저장할 내용을 입력하세요: ')
f = open('mydata.txt', 'w')
f.write(text)

f.close()