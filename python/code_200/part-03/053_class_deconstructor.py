#!/usr/bin/env python
#-*- coding: utf-8 -*-


# 인스턴스가 생성 될 때, 생성자가 실행된다면, 
# 인스턴스가 소멸 될 때, 소멸자(deconstrutor)가 실행됩니다. 


class MyClass():
    def __init__(self):
        print('I am a constructor.')

    def __del__(self):
        print('I am a deconstructor.')


obj = MyClass()
del obj