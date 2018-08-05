#!/usr/bin/env python
#-*- coding: utf-8 -*-

# 'import' 키워드를 사용하여 파이썬 내장된 함수와 모듈을 임포트 한다.
# 모듈은 사용자가 만들어서 사용할 수 있으며, 기 파이썬에서 제공하는 내장된 모듈이 있다.
# 모듈은 만드는 기준은 없지만, 관례상 코드의 기능적 특징을 분류하여 체계적인 관리를 위한 것이다. 
# 이렇게 관리하면 디버깅 등의 유지보수에도 편리하다.

import time


print('5초간 프로그램을 정지합니다.')
time.sleep(5)   # time 클래스와 sleep() 함수는 import time 구문 때문이다.

print('5초가 지났습니다.')


# 사용자 모듈인 mylib.py 이라는 파일 확인합니다.
import mylib
ret1 = mylib.add_tx('파이썬 ', '일등')
print(ret1)

ret2 = mylib.reverse(1, 2, 3)
print(ret2)