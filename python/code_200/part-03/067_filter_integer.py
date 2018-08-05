#!/usr/bin/env python
#-*- coding: utf-8 -*-


def get_prime(x):
    for i in range(2, x-1):
        if x % i == 0:
            break
    else:
        return x


listdata = [117, 119, 1113, 11113, 11119]
ret = filter(get_prime, listdata)
print(list(ret))