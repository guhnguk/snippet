#!/usr/bin/env python3
# -*- coding: utf-8 -*-


import os
import shutil


target_folder = 'tmp'
print('[%s] 하위 모든 디렉터리 및 파일들을 삭제합니다.' %target_folder)

for file in os.listdir(target_folder):
    print(file)

answer = input('[%s]를 삭제하겠습니까? (y/n)' %target_folder)

if answer == 'y':
    try:
        shutil.rmtree(target_folder)
        print('[%s]의 모든 하위 디렉터리와 파일들을 삭제했습니다. ' %(target_folder))
    except Exception as e:
        print(e)