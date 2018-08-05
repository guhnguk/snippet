#!/usr/bin/env python3
# -*-coding: utf-8 -*-


listdata = []
for i in range(3):
    txt = input('리스트에 추가 할 값을 입력하세요[%d/3]: ' %(i+1))
    listdata.append(txt)
    print(listdata)