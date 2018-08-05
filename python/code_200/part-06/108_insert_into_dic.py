#!/usr/bin/env python3
# -*- coding: utf-8 -*-


solarsys1 = ['Sun', 'Mercury', 'Venus', 'Earth', 'Mars', 'Jupiter', 'Saturn', 'Uranus', 'Neptune', 'Pluto']
solarsys2 = ['태양', '수성', '금성', '지구', '화성', '목성', '토성', '천왕성', '해왕성', '명왕성']

solardict = {}
for i, k in enumerate(solarsys1):
    val = solarsys2[i]
    solardict[k] = val

print(solardict)