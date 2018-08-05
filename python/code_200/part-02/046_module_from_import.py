#!/usr/bin/env python
#-*- coding: utf-8 -*-


from time import sleep
from mypackage import mylib
from mypackage.mylib import reverse


sleep(1)
mylib.add_tx('나는 ', '파이썬이 좋아요')
reverse(1, 2, 3)