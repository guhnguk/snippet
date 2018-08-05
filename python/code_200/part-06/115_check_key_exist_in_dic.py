#!/usr/bin/env python3
# -*- coding: utf-8 -*-


names = {'Mary':10999, 'Sams':2111, 'Aimy':9778, 'Tom':20245, 'Michale':27115, 'Bob':5887, 'Kelly':7855}
print(names)

print('---------------------')
k = input('이름을 입력하세요: ')
if k in names:
    print('이름이 <%s>인 출생아 수는 <%d>명 입니다.' %(k, names[k]))
else:
    print('자료에 <%s>인 이름이 존재하지 않습니다.' %k)



print('---------------------')
print('---------------------')

#
# 아래 코드는 값을 확인하는 코드입니다. 그런데, 제대로 작동하지 않습니다. 수정하세요.
#
v = input('값을 입력하세요: ')
if v in names.values():
    print('주어진 값이 사전에 존재합니다.')
else:
    print('주어진 값이 사전에 존재하지 않습니다. ')