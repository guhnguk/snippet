#!/usr/bin/env python3
# -*- coding: utf-8 -*-


f = open('./stockcode.txt', 'r')
data = f.read()
print(data)
f.close()

# 파일 크기가 크면, read(), readline()함수를 사용하는 것은 권장하지 않는다.