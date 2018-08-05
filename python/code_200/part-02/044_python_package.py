#!/usr/bin/env python
#-*- coding: utf-8 -*-

# 파이썬 모듈이 하나의 파일이라고 가정하면,
# 파이썬 패키지는 디렉터리라고 생각하면 됩니다.
# 하나의 디렉터리에 많은 파일이 있듯이, 하나의 패키지에는 많은 모듈이 존재 합니다.

# 아래의 지시를 따라 주세요.

# 1. mypackage 라는 이름의 디렉터리를 만듭니다. 
# 2. mypackage 디렉터리로 이동합니다. 
# 3. 043_python_module.py 에서 사용했던 'mylib.py' 모듈을 'mypackage' 디렉터리에 복사합니다.
# 4. 'mypackage' 디렉터리에 'version=1.0'을 내용으로 '__init__.py'(underbar 2개) 파일을 생성합니다. 
# 5. 서브 디렉터리를 생성하여 하위 패키지도 생성할 수 있습니다. 
# 6. 아래 코드처럼 '패키지'를 import 합니다. 


import mypackage.mylib

# ret1 = mypackage.mylib.add_tx('파이썬', '일등')
# print(ret1)
# 
# ret2 = mypackage.mylib.reverse(1, 2, 3)
# print(ret2)


print(mypackage.mylib.add_tx('파이썬', '일등'))
