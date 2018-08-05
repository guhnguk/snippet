#!/usr/bin/env python
# -*- coding: utf-8 -*-

bit1 = 0x61
bit2 = 0x62

print(hex(bit1 & bit2))     # 0x60 출력
print(hex(bit1 | bit2))     # 0x63 출력
print(hex(bit1 ^ bit2))     # 0x3 출력
print(hex(bit1 >> 1))       # 0x30 출력
print(hex(bit1 << 2))       # 0x184 출력

# 0x61 hex 값을 10진수로 출력 해 보세요.


# 위에서 변경한 10진수 값은 실제 어떤 값일지 확인해 보세요.
