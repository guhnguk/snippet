#!/usr/bin/env python3
# -*- coding: utf-8 -*-


f = lambda x: x * x
args = [1, 2, 3, 4, 5]
ret = map(f, args)
print(ret)
print(list(ret))


print('-----------------')

f = lambda x, y: x*x + y
x = [1, 2, 3, 4, 5]
y = [10, 9, 8, 7, 6]

ret = map(f, x, y)
print(list(ret))