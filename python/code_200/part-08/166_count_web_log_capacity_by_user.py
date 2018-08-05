#!/usr/bin/env python3
# -*- coding: utf-8 -*-


services = {}

with open('access_log', 'r') as f:
    logs = f.readlines()
    for log in logs:
        log = log.split()
        ip = log[0]

        service_byte = log[9]
        if service_byte.isdigit():
            service_byte = int(service_byte)
        else:
            service_byte = 0

        if ip not in services:
            services[ip] = service_byte
        else:
            services[ip] += service_byte


ret = sorted(services.items(), key=lambda x:x[1], reverse=True)

print('사용자 IP - 서비스 용량')
for ip, b in ret:
    print('[%s] - [%d]' %(ip, b))