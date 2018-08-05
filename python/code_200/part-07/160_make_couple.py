#!/usr/bin/env python3
# -*- coding: utf-8 -*-


from random import shuffle


male = ['Leonardo', 'Tom', 'Brad', 'Johnny', 'Hugh']
female = ['Charlize', 'Jennifer', 'Sandra', 'Eva', 'Monica']

shuffle(male)
shuffle(female)

couples = zip(male, female)

for i, couple in enumerate(couples):
    print('Couple %d: [%s]-[%s]' %(i+1, couple[0], couple[1]))