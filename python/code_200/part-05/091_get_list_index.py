#!/usr/bin/env python3
# -*-coding: utf-8 -*-


solarsys = ['Sun', 'Mercury', 'Venus', 'Earth', 'Mars', 'Jupiter', 'Saturn', 'Uranus', 'Neptune', 'Pluto', 'Earth']
planet = 'Earth'

pos = solarsys.index(planet)
print('%s는 태양계에서 %d번째에 위치하고 있습니다.' %(planet, pos))

pos = solarsys.index(planet, 5)
print('%s는 태양계에서 %d번째에 위치하고 있습니다.' %(planet, pos))
