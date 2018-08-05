#!/usr/bin/env python3
# -*- coding: utf-8 -*-


from urllib.request import urlopen


url = 'https://www.python.org'
with urlopen(url) as f:
    doc = f.read().decode()
    print(doc)


print('=======================================')


with urlopen(url) as f:
    doc = f.read().decode()
    with open('pythonhome.html', 'w') as h:
        h.writelines(doc)
