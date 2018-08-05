#!/usr/bin/env python3
# -*- coding: utf-8 -*-


# 파일을 읽는 위치 지정
spos = 105

# 읽을 크기를 지정
size = 100

f = open('stockcode.txt', 'r')
h = open('stockcode_part.txt', 'w')

f.seek(spos) # 읽을 위치 선정
data = f.read(size) # 사이즈 만큼 읽음
h.write(data)

h.close()
f.close()