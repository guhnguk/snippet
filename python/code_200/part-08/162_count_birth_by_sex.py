#!/usr/bin/env python3
# -*- coding: utf-8 -*-


def count_birth_by_sex():
    ret = []


    for y in range(1880, 2015):
        count_f = 0
        count_m = 0

        file_name = './names/yob%d.txt' %y
        with open(file_name, 'r') as f:
            data = f.readlines()
            for d in data:
                if d[-1] == '\n':
                    d = d[:-1]

                    tmp = d.split(',')
                    sex = tmp[1]
                    birth = tmp[2]

                    if sex == 'F':
                        count_f += int(birth)
                    else:
                        count_m += int(birth)

        ret.append((y, count_f, count_m))

    return ret


result = count_birth_by_sex()
with open('birth_by_sex.csv', 'w') as f:
    for y, bf, bm in result:
        data = '%s, %s, %s\n' %(y, bf, bm)
        print(data)

        f.write(data)
