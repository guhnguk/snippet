#!/usr/bin/env python3
# -*-coding: utf-8 -*-


solarsys = ['Sun', 'Mercury', 'Venus', 'Earth', 'Mars', 'Jupiter', 'Saturn', 'Uranus', 'Neptune', 'Pluto', 'Earth']
planet = 'Mars'
pos = solarsys.index(planet)
solarsys[pos] = '화성'
print(solarsys)