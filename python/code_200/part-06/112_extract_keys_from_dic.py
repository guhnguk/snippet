#!/usr/bin/env python3
# -*- coding: utf-8 -*-


names = {'Mary':10999, 'Sams':2111, 'Aimy':9778, 'Tom':20245, 'Michale':27115, 'Bob':5887, 'Kelly':7855}
print(names)
print('--------------------------')
keys = names.keys()
print(keys)


for key in keys:
    print('Key: %s \t Value: %d' %(key, names[key]))