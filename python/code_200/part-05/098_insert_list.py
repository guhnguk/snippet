#!/usr/bin/env python3
# -*-coding: utf-8 -*-


solarsys = ['Sun', 'Mercury', 'Venus', 'Earth', 'Mars', 'Jupiter', 'Saturn', 'Uranus', 'Neptune', 'Pluto', 'Earth']
pos = solarsys.index('Jupiter')
solarsys.insert(pos, 'Small planet')
print(solarsys)