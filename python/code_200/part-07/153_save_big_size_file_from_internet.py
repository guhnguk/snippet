#!/usr/bin/env python3
# -*- coding: utf-8 -*-


from urllib.request import urlopen

BUFSIZE = 1024 * 256


fileurl = 'https://www.python.org/ftp/python/3.5.2/python-3.5.2.exe'
filename = fileurl.split('/')[-1]

try:
    with urlopen(fileurl) as f:
        with open(filename, 'wb') as h:
            buf = f.read(BUFSIZE)
            while buf:
                h.write(buf)
                buf = f.read(BUFSIZE)

except Exception as e:
    print(e)