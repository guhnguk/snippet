#!/usr/bin/env python
#-*- coding: utf-8 -*-


# 모듈을 임포트 하는 방법
# import 모듈이름
# import 패키지이름.모듈이름
#
# 만약 존재하지 않은 모듈을 임포트 하면 다음과 같은 에러가 납니다.
# ImportError: No module named '모듈이름'

import time
import mylib
import mypackage.mylib

time.sleep(1)
mylib.add_tx('나는 ', '파이썬이 좋아요')
mypackage.mylib.reverse(1, 2, 3)