#!/usr/bin/env python3
# -*- coding: utf-8 -*-


import os


target_folder = input('삭제 할 디렉터리 이름은 무엇인가요?: ')
try:
    answer = input('[%s] 디렉터리를 삭제하겠습니까? (Y/n)' %(target_folder))
    if answer == 'y' or answer == 'Y':
        os.rmdir(target_folder)
        print('[%s] 디렉터리를 삭제했습니다.' %target_folder)
except Exception as e:
    print(e)
