#!/usr/bin/env python3
# -*-coding: utf-8 -*-

u_txt = 'I love python'
b_txt = u_txt.encode()
print(u_txt)
print(b_txt)

ret1 = 'I' == u_txt[0]
ret2 = 'I' == b_txt[0]

print(ret1)
print(ret2)

print('---------------------')
b_txt1 = b'A lot of things occur each day.'
u_txt1 = b_txt1.decode()
print(u_txt1)