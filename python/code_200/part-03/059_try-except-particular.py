#!/usr/bin/env python
#-*- coding: utf-8 -*-


import time

#프로그램을 실행 시키고 Ctrl + c 로 프로그램을 강제 종료 합니다. 
count = 1
try:
    while True:
        print(count)
        count += 1
        time.sleep(0.5)
except KeyboardInterrupt:
    print('사용자가 프로그램을 강제로 중단 시켰습니다.')