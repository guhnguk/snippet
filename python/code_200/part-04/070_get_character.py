#!/usr/bin/env python3
# -*- coding: utf-8 -*-

txt1 = 'A tale that was not right'
txt2 = '다시 새로 태어나리라'

print(txt1[5])
print(txt2[-2])

print('--------------')
print(txt1[3:7])
print(txt1[:6])
print(txt2[-4:])

print('--------------')

txt3 = 'python'
for i in range(len(txt3)):
    print(txt3[:i+1])

print('--------------')

txt4 = 'aAbBcCdDeEfFgGhHiIjJkK'
ret = txt4[::2] # abcdefghijk 출력 됩니다. 
print(ret)

# txt4 문자열에서 ABCDEFGHIJK가 출력 되도록 24행(ret = txt4[::2])을 수정합니다.  

print('--------------')

# 문자열을 거꾸로 출력
txt5 = 'abcdefghijk'
ret = txt5[::-1]
print(ret)

# txt5를의 슬라이싱을 조절하여, 거꾸로 홀수 번째 문자만 추출, 출력합니다. 
ret = txt5[::-2]
print(ret)

# txt5를의 슬라이싱을 조절하여, 거꾸로 짝수 번째 문자만 추출, 출력합니다. 
ret = txt5[-2::-2]
print(ret)