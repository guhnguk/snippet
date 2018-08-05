#!/usr/bin/env python3
# -*- coding: utf-8 -*-


def count_births():
    ret = []

    for y in range(1880, 2015):
        count = 0

        file_name = './names/yob%d.txt' %y
        try :
            with open (file_name, 'r') as f:
                data = f.readlines()

                for d in data:
                    if d[-1] == '\n':
                        d = d[:-1]

                        birth = d.split(',')[2]
                        count += int(birth)

            ret.append((y, count))
        except Exception as e: 
            print(e) 
    
    return ret


result = count_births()
with open('./birth_by_year.csv', 'w') as f:
    for year, birth in result:
        data = '%s, %s\n' %(year, birth)
        print(data)
        f.write(data)