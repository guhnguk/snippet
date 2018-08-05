#!/usr/bin/env python3
# -*- coding: utf-8 -*-


import os


pdir = os.getcwd()
print(pdir)

os.chdir('..')
print(os.getcwd())

os.chdir(pdir)
print(os.getcwd())