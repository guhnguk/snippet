#!/usr/bin/env python
#-*- coding: utf-8 -*-


# Constructor(생성자)는 인스턴스가 생성될 때 자동으로 실행하는 메쏘드
# 형태:
# def __init__(self, *args)
# 
# *args는 040에서 설명했습니다. 다시 설명하면 argument가 몇 개가 올지 모르기 때문에 가변인자(variable argument)로 정의 합니다. 

class MyClass1():
    def __init__(self):
        self.var = 'How are you?'
        print('MyClass 인스턴스가 생성되었습니다. ')


obj = MyClass1()
print(obj.var)


class MyClass2():
    def __init__(self, name):
        self.var = name
        print('MyClass 인스턴스가 생성되었습니다. 전달받은 파라미터는 <' + name + '> 입니다.')

obj = MyClass2('Kris')
