#!/usr/bin/env python3
# -*- coding: utf-8 -*-


from os.path import exists


def get_top10_baby_by_name(year):
    name_f = {}
    name_m = {}

    file_name = './names/yob%s.txt' %year

    if not exists(file_name):
        print('[%s] 파일이 존재하지 않습니다. ' %file_name)
        return None

    with open(file_name, 'r') as f:
        data = f.readlines()

        for d in data:
            if d[-1] == '\n':
                d = d[:-1]

                tmp = d.split(',')
                name = tmp[0]
                sex = tmp[1]
                birth = tmp[2]

                if sex == 'F':
                    ret = name_f
                else:
                    ret = name_m

                if name in ret:
                    ret[name] += int(birth)
                else:
                    ret[name] = int(birth)
    ret_f = sorted(name_f.items(), key=lambda x:x[1], reverse=True)
    ret_m = sorted(name_m.items(), key=lambda x:x[1], reverse=True)

    for i, name in enumerate(ret_f):
        if i > 9:
            break
        print("TOP_%d 여자 아기 이름 %s" %(i+1, name))

    for i, name in enumerate(ret_m):
        if i > 9:
            break
        print("TOP_%d 남자 아기 이름 %s" % (i + 1, name))

y = input('인기순 상위 10개 이름을 알고 싶은 1880~2015 사이의 출생년도를 입력하세요(예: 2001): ')
get_top10_baby_by_name(y)