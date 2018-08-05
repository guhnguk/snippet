#!/usr/bin/env python
#-*- coding: utf-8 -*-


# 기본 인자는 마지막에 위치해야 합니다.
#def add_txt(t1='파이썬', t2):
def add_txt(t1, t2='파이썬'):
    print(t1 + ':' + t2)


add_txt('베스트')
add_txt(t2='대한민국', t1='1등')


def func1(*args):
    print(args)


def func2(width, height, **kwargs):
    print(kwargs)


func1()
func1(3, 5, 1, 5)
func2(10, 20)
func2(10, 20, depth=50, color='blue')

print('-------------------------')
def som_func(t1, t2='알', t3='파이썬'):
    print(t3 + '이 '+ t2 + '보다 '+ t1 + ' 쉬워요.')

som_func('5배')

print('-------------------------')
func2(600, 800, )