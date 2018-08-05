#!/usr/bin/env python3
# -*- coding: utf-8 -*-


from time import localtime, strftime

#
# 인덱스:0 | tm_year = 2017, 현재 년도 예)2017
# 인덱스:1 | tm_mon = 9, 현재 월, [1~12]
# 인덱스:2 | tm_mday = 27, 현재 날짜, [1~31]
# 인덱스:3 | tm_hour = 22, 현재 시간, [0~23]
# 인덱스:4 | tm_min = 40, 현재 분, [0~59]
# 인덱스:5 | tm_sec = 42, 현재 초, [0~61], 61은 윤초
# 인덱스:6 | tm_wday = 1, 현재 요일, [0~6], 0은 월요일을 뜻함
# 인덱스:7 | tm_yday = 271, 1월 1일부터 현재까지 날짜 수, [1~366]
# 인덱스:8 | tm_isdst = 0, 섬머타임일 경우 1, 아닐 경우 0, 모를 경우 -1

logfile = 'test.log'

def writelog(logfile, log):
    time_stamp = strftime('%Y-%m-%d %X\t', localtime())
    log = time_stamp + log + '\n'

    with open(logfile, 'a') as f:
        f.writelines(log)

writelog(logfile, '첫 번째 로깅 문장입니다.')


#
#   %Y  - 년도를 나타냄 예) 2017
#   %m  - 월을 나타냄 예) 9월인 경우 09
#   %d  - 일을 나타냄 예) 15일 경우 15
#   %H  - 시간을 24시간 표시 형식으로 나타냄 예) 8시인 경우 08
#   %M  - 분을 나타냄 예) 45분인 경우 45
#   %S  - 초를 나타냄 예) 1초인 경우 01
#   %x  - 현재 날짜를 월/일/년으로 나타냄 예) 2017년 9월 27일은 09/27/17
#   %X  - 현재 날짜를 시:분:초로 나타냄 예) 22시 10분 15초는 22:10:15
#
