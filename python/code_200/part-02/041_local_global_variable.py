#!/usr/bin/env python
#-*- coding: utf-8 -*-


# 전역변수는 코딩 전체에서 참조(사용)할 수 있는 변수
# 지역변수는 함수 내에서만 참조(사용)할 수 있는 변수

param = 10
strdata = '전역변수'


def func1():
    strdata = '지역변수'
    print(strdata)


def func2(param):
    param = 1


def func3():
    global param
    param = 50


func1()
print(strdata)
print(param)

func2(param)
print(param)

func3()
print(param)
