#!/usr/bin/env python
#-*- coding: utf-8 -*-


class MyClass():
    def sayHello(self):
        print('How are you?')

    def sayBy(self, name):
        print('%s! 다음에 보자' %name)


obj = MyClass()
obj.sayHello()
obj.sayBy('Kris')