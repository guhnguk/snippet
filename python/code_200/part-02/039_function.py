#!/usr/bin/env python
#-*- coding: utf-8 -*-


# 함수 정의 방법

# def function_name([parameter1], [parameter2], ...):
#     [some code]
#     return [result value]
# argument는 있을 수도 있고, 없을 수도 있음
# return 코드는 있을 수도 있고, 없을 수도 있음
#

# 함수 호출하는 방법

# variable = function_name([argument1], [argument2])

def add_number(n1, n2):
    ret = n1 + n2
    return ret


def add_tx(t1, t2):
    print(t1 + t2)


ans = add_number(10, 15)
print(ans)

text1 = '대한민국~ '
text2 = '만세!'

add_tx(text1, text2)