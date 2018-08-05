#!/usr/bin/env python3
# -*- coding: utf8 -*-


a, b = map(int, input().strip().split(" "))
quotient = a // b
reminder = a % b

print(quotient, reminder)

# 파이썬 답게 작성하는 방법은 몫과 나머지를 동시에 구한다.
print(*divmod(a, b))
