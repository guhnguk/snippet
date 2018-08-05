#!/usr/bin/env python3
# -*- coding: utf-8 -*-


page_view = 0

with open('access_log', 'r') as f:
    logs = f.readlines()
    for log in logs:
        log = log.split()
        status = log[8]

        if status == '200':
            page_view += 1

print('총 페이지 뷰: [%d]' %page_view)