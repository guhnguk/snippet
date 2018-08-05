#!/usr/bin/env python3
# -*- coding: utf-8 -*-


KB = 1024
total_service = 0


with open('access_log', 'r') as f:
    logs = f.readlines()
    for log in logs:
        log = log.split()
        service_byte = log[9]

        if service_byte.isdigit():
            total_service += int(service_byte)


total_service /= KB
print('총 서비스 용량: %dKB' %total_service)