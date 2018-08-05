#!/usr/bin/env python3
# -*-coding: utf-8 -*-


txt1 = '안녕하세요?'
txt2 = '1.Title-제목을 넣으세요'
txt3 = '3피오R2D2'

ret1 = txt1.isalnum()
ret2 = txt2.isalnum()
ret3 = txt3.isalnum()

print(ret1) # ? 때문에 False
print(ret2) # .과 - 때문에 False
print(ret3)