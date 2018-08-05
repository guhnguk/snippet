#!/usr/bin/env python
#-*- coding: utf-8 -*-

# 슬라이스 구조 => [start_index:end_index:step]
# start_index <= [start_index:end_index] < end_index

# [m:n] 시퀀스 자료의 인덱스가 m 이상, n 미만의 요소를 슬라이싱
# [:n] 시퀀스 자료의 처음부터 인덱스 n 미만의 요소까지 슬라이싱
# [m:] 시퀀스 자료의 인덱스가 m 인 요소부터 시퀀스 자료의 끝까지 슬리이싱
# [:-n] 시퀀스 자료의 처음부터 끝에서 n 번째 미만인 요소까지 슬라이싱
# [-m:] 시퀀스 자료의 끝에서 m 번째 요소부터 시퀀스 자료의 끝까지 슬라이싱

strdata = 'Time is money!!'

# 무엇이 출력이 될지 미리 맞춰봅니다.
print(strdata[1:5])
print(strdata[:7])
print(strdata[9:])
print(strdata[:-3])
print(strdata[-3:])
print(strdata[:])
print(strdata[::2])


# Q. 'Tesoy'를 출력합니다.