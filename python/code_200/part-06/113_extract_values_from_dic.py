#!/usr/bin/env python3
# -*- coding: utf-8 -*-


names = {'Mary':10999, 'Sams':2111, 'Aimy':9778, 'Tom':20245, 'Michale':27115, 'Bob':5887, 'Kelly':7855}
print(names)

print('--------------------')
values = names.values()
print(values)

print('--------------------')
values_list = list(values)
ret = sum(values_list)
print('출생아 수 총계: %d' %ret)