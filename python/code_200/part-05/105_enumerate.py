#!/usr/bin/env python3
# -*-coding: utf-8 -*-


solarsys = ['Sun', 'Mercury', 'Venus', 'Earth', 'Mars', 'Jupiter', 'Saturn', 'Uranus', 'Neptune', 'Pluto']
ret = list(enumerate(solarsys))
print(ret)

for i, body in enumerate(solarsys):
    print('태양계의 %d번째 천체:%s' %(i, body))