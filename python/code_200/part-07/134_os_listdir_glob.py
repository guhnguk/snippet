#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import os, glob


folder = '/Volumes/Workspace/git/python/deliberate-learningdeliberate-learning/part-07'
file_list = os.listdir(folder)
print(file_list)

files = '*.txt'
file_list = glob.glob(files)

print(file_list)