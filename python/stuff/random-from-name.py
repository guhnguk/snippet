# -*- coding:utf-8 -*-
__author__ = 'Ryan Guhnguk Ahn'


import random


def read_from_file(file_name):
    with open(file_name, 'r') as f:
        name_list = f.readlines()
        # for line_num, line in enumerate(name_list):
        #     print('%d %s' % (line_num + 1, line), end='')

    return name_list


def random_pick(name_list):
    length = len(name_list)

    randome_int = random.randrange(1, length)
    name = name_list.pop(randome_int)

    return name


if __name__ == "__main__":
    name_list = read_from_file('./name.text')
    print(name_list)
    pick_name = random_pick(name_list)
    print(pick_name)