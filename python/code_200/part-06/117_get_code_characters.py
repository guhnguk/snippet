#!/usr/bin/env python3
# -*- coding: utf-8 -*-


ch = input('문자를 1개를 입력하세요: ')
if len(ch) != 0:
    ch = ch[0]
    chv = ord(ch)

    print('문자: %s \t 코드값: %d [%s]' %(ch, chv, hex(chv)))


print('-----------------------')

val = input('문자 코드 값을 입력하세요: ')
val = int(val)

try:
    ch = chr(val)
    print('코드값: %d [%s], 문자: %s' %(val, hex(val), ch))

except ValueError:
    print('입력한 <%d>에 대한 문자가 존재하지 않습니다.!' %val)