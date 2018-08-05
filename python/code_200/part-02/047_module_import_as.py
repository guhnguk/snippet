#!/usr/bin/env python
#-*- coding: utf-8 -*-


# alias 방법
# 긴 모듈 임포트를 alias 시킴
# import 이름이 긴 모듈명 as 별명

import mypackage as mp
import mypackage.mylib as ml 

print(mp.mylib.add_tx('파이썬', '1등'))
print(ml.reverse(1, 2, 3))