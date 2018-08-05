#!/usr/bin/env python3
# -*-coding: utf-8 -*-


solarsys = ['Sun', 'Mercury', 'Venus', 'Earth', 'Mars', 'Jupiter', 'Saturn', 'Uranus', 'Neptune', 'Pluto']

rock_planets = solarsys[1:4]
gas_planets = solarsys[4:]

print('Rock type of Solar system: ', end='')
print(rock_planets)

print('Gas type of Solar system: ', end='')
print(gas_planets)


#
# extract even number in list
#
print('--------------------------')
listdata = list(range(1, 21))
evenlist = listdata[1::2]
print(evenlist)