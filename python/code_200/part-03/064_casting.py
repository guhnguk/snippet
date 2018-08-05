#!/usr/bin/env python
#-*- coding: utf-8 -*-

#
# 10진수 16진수로 변환하기
#

h1 = hex(97)
h2 = hex(98)
ret1 = h1 + h2
print(ret1)         # 0x610x62

print('------------------------------')
a = int(h1, 16)
b = int(h2, 16)
ret2 = a + b
print(ret2)         # 195
print(hex(ret2))    # 0xc3

print('------------------------------')
# formatting
n = 159
print('%X' %n)
print('%x' %n)

n = 11
print('%02X' %n)
print('%02x' %n)

print('------------------------------')

#
# 10진수 16진수로 변환하기
#

b1 = bin(97)        # b1: '0b11000001'
b2 = bin(98)        # b2: '0b11000010'
ret1 = b1 + b2
print(ret1)
print('------------------------------')
a = int(b1, 2)
a = int(b2, 2)
ret2 = a + b
print(ret2)
print(bin(ret2))    # '0b11000011'


bnum = 0b11110000
bstr = '0b11110000'
b1 = int(bnum)
b2 = int(bstr, 2)
print(b1)
print(b2)

onum = 0o360
ostr = '0o360'
o1 = int(onum)
o2 = int(ostr, 2)
print(o1)
print(o2)

hnum = 0xf0
hstr = '0xf0'
h1 = int(hnum)
h2 = int(hstr, 2)
print(h1)
print(h2)





b1 = int(bnum)
b2 = int(bstr, 2)