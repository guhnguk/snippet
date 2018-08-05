#!/usr/bin/env python3
# -*- coding: utf-8 -*-


names = {'Mary':10999, 'Sams':2111, 'Aimy':9778, 'Tom':20245, 'Michale':27115, 'Bob':5887, 'Kelly':7855}
print(names)

print('---------------------------')
ret1 = sorted(names)
print(ret1)

print('아이템들은 ...')
print(names.items())
print('---------------------------')

def f1(x):
    return x[0]


def f2(x):
    return x[1]

print('첫 번째 요소')
ret2 = sorted(names.items(), key=f1)
print(ret2)

print('---------------------------')
print('두 번째 요소')
ret3 = sorted(names.items(), key=f2)
print(ret3)

print('---------------------------')
print('두 번째 요소의 후순 정렬')
ret4 = sorted(names.items(), key=f2, reverse=True)
print(ret4)
