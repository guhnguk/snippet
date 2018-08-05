#!/usr/bin/env python3
# -*-coding: utf-8 -*-


listdata = list(range(5))
listdata.reverse()
print(listdata)

print('------------------------')

ret1 = reversed(listdata)
print('원본 리스트', end='')
print(listdata)
print('역순 리스트', end='')
print(list(ret1))

print('------------------------')

ret2 = listdata[::-1]
print('슬라이싱 이용', end='')
print(ret2)