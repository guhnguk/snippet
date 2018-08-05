#!/usr/bin/env python3
# -*- coding: utf-8 -*-


#
# 파이썬에서 함수 정의는 
# def 함수이름(파리미터, ...):
#   실행코드
#

# 람다 표현식
# lambda 파라미터, ... : 실행코드

add = lambda x, y: x + y

ret = add(1, 3)
print(ret)


funcs = [lambda x: x + '.pptx', lambda x: x +'.docx']
ret1 = funcs[0]('Intro')
ret2 = funcs[1]('Report')

print(ret1)
print(ret2)

names = {'Mary':10999, 'Sams':2111, 'Aimy':9778, 'Tom':20245, 'Michale':27115, 'Bob':5887, 'Kelly':7855}
ret3 = sorted(names.items(), key=lambda x: x[0])
print(ret3)