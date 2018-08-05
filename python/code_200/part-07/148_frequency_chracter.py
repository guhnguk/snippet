#!/usr/bin/env python3
# -*- coding: utf-8 -*-


def get_char_freq(filename):
    with open(filename, 'r') as f:
        text = f.read()
        charater_freq = {}

        for ch in text:
            if ch in charater_freq:
                charater_freq[ch] +=1
            else:
                charater_freq[ch] = 1

    return charater_freq

ret = get_char_freq('mydata.txt')
ret = sorted(ret.items(), key=lambda x: x[1], reverse=True)

for ch, freq in ret:
    if ch == '\n':
        continue
    print('[%c] -> [%d]회 나타남' %(ch, freq))