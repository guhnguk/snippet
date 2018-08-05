#!/usr/bin/env python3
# -*- coding: utf-8 -*-


from time import localtime


t = localtime() # 현재시간
start_day = '%d-01-01' %t.tm_year

elapsed_day = t.tm_yday

print('오늘은 [%s]이후 [%d]일째 되는 날입니다.' %(start_day, elapsed_day))

print('-----------------')

weekdays = ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일']

t = localtime()
today = '%d-%d-%d' %(t.tm_year, t.tm_mon, t.tm_mday)
week = weekdays[t.tm_wday]

print('[%s] 오늘은 [%s]입니다. ' %(today, week))