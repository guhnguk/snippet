#!/usr/bin/env python
#-*- coding: utf-8 -*-

a = 11113
b = 23
ret1, ret2 = divmod(a, b)
ret = a%b
print('<%d/%d>는 몫이 <%d>, 나머지가 <%d>입니다.' %(a, b, ret1, ret2))