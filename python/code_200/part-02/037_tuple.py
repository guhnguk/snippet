#!/usr/bin/env python
#-*- coding: utf-8 -*-


# 튜플은 Immutable 타입니다. 
# 아래 코드에는 에러가 있습니다. 수정합니다.

tuple1 = (1, 2, 3, 4, 5)
tuple2 = ('a', 'b', 'c')
tuple3 = (1, 'a', 'abc', [1, 2, 3, 4, 5], ['a', 'b', 'c'])
tuple1[0] = 6

def myfunc1():
    print('Hello')

def myfunc2(abc):
    print(abc)

tuple4 = (1, 2, myfunc1, myfunc2)
tuple4[2]()
tuple4[3]('World')