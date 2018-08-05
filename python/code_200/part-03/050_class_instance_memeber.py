#!/usr/bin/env python
#-*- coding: utf-8 -*-


class MyClass:
    var = 'How are you'

    def doSomthing1(self):
        print(self.param2)

    def sayHello(self):
        param1 = 'Hello'

        self.param2 = 'Hi'

        print(param1)
        print(self.var)
    
    def doSomthing2(self):
        print(self.param2)


obj = MyClass()
print(obj.var)

# 주석을 풀고 어떤 에러가 났는지 확인하세요.
#obj.doSomthing1()
obj.sayHello()

# 주석을 풀고 어떤 에러가 났는지 확인하세요.
#obj.param1

print('--------------------')
obj.doSomthing2()
