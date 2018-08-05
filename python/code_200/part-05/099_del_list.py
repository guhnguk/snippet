#!/usr/bin/env python3
# -*-coding: utf-8 -*-


solarsys = ['Sun', 'Mercury', 'Venus', 'Earth', 'Mars', 'Jupiter', 'Saturn', 'Uranus', 'Neptune', 'Pluto', 'Earth']
del solarsys[0]
print(solarsys)
del solarsys[-2]
print(solarsys)

print('-----------------')
del solarsys[1:3]
print(solarsys)

print('-----------------')
listdata = [2, 2, 1, 3, 8, 5, 7, 6, 3, 6, 2, 3, 9, 4, 4]
del listdata
print(listdata)