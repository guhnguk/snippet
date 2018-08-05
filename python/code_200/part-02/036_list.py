#!/usr/bin/env python
# -*- coding: utf-8 -*-

import time
from time import strftime


list1 = [1, 2, 3, 4, 5]
list2 = ['a', 'b', 'c']
list3 = [1, 'a', 'abc', [1, 2, 3, 4, 5], ['a', 'b', 'c']]

list1[0] = 6
print(list1)

def myfunc1():
    print('Hello')

def myfunc2(abc):
    print(abc)

# 다음 구문을 잘 살펴 보고 숙지
list4 = [1, 2, myfunc1, myfunc2 ]
list4[2]()
list4[3]('World')

print("------------------------------------------")
# b_list = a_list.copy()
# b_list = a_list[:]
a_list = [i for i in range(5)]
a_list.append(-1)
print(a_list)

b_list = [i for i in a_list]    # 가장 좋음
print(b_list)

c_list = a_list.copy()          # so so 함
print(c_list)

d_list = a_list[:]              # so so 함
print(d_list)

print("------------------------------------------")
a = [x for x in a_list if x >= 0]
print(a)

a = [x**2 for x in a_list]
print(a)

a = [1/x for x in a_list if x != 0]
print(a)

print("------------------------------------------")

a = " abcd "
a = [a.split() for i in a if i.split()]
print(a)