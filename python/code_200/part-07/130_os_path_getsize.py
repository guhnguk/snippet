#!/usr/bin/env python3
# -*- coding: utf-8 -*-


from os.path import getsize


file1  = 'stockcode.txt'
file2  = 'img_sample.jpg'

file_size1 = getsize(file1)
file_size2 = getsize(file2)

print('File Name: %s \t File Size: %d' %(file1, file_size1))
print('File Name: %s \t File Size: %d' %(file2, file_size2))