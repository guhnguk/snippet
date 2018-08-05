#!/usr/bin/env python
#-*- coding: utf-8 -*-


# 클래스는 부모가 있고 자식이 있습니다. 
# 그래서 부모가 자식에게 상속을 하 듯, 부모 클래스는 자식 클래스에게 멤버들을 상속합니다. 
#
# 정의:
#   class childClass(parentClass1, parentClass2, ...):

class Add:
    def add(self, n1, n2):
        return n1 + n2


class Muliply:
    def mulitply(sefl, n1, n2):
        return n1 * n2


class Caculation1(Add):
    def sub(self, n1, n2):
        return n1 - n2


class Caculation2(Add, Muliply):
    def sub(self, n1, n2):
        return n1 - n2


obj = Caculation1()
print(obj.add(1,2))
print(obj.sub(1,2))

print('-------------------------')
obj = Caculation2()
print(obj.add(1,2))
print(obj.sub(1,2))
print(obj.mulitply(1,2))