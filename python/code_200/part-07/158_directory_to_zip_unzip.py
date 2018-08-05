#!/usr/bin/env python3
# -*- coding: utf-8 -*-


from zipfile import *
import os


def compress_all(zipname, folder):
    print('[%s] -> [%s] 압축 ... ' %(folder, zipname))

    with ZipFile(zipname, 'w') as ziph:
        for dirname, subdirs, files in os.walk(folder):
            for file in files:
                ziph.write(os.path.join(dirname, file))


folder = 'tmp'
zipname = folder + '.zip'
compress_all(zipname, folder)

print('-----------------------')

def extract_zip(zipname):
    with ZipFile(zipname, 'r') as ziph:
        ziph.extractall()
        print('[%s]가 성공적으로 추출되었습니다.' %zipname)

extract_zip('tmp.zip')