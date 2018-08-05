#!/usr/bin/env python3
# -*- coding: utf-8 -*-


from datetime import datetime


start = datetime.now()
print('1에서 백만까지 더합니다.')

ret = 0
for i in range(1000000):
    ret += i

print('1에서 백만까지 더한 결과: %d' %ret)
end = datetime.now()

elasped = end - start
print('총 계산 시간: ', end='')
print(elasped)
elasped_ms = int(elasped.total_seconds() * 1000)
print('총 계산 시간: %dms' %elasped_ms)