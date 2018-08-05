#!/usr/bin/env python
# -*- coding: utf-8 -*-

# Integer는 정수형 자료를 나타 냄

# 10진수
int_data = 10
print(int_data)

# 2진수 --> 0b prefix로 하면 python은 2진수로 인식 함
bin_data = 0b10
print(bin_data)

# 8진수 --> 0o prefix로 하면 python은 8진수로 인식 함
oct_data = 0o10
print(oct_data)

# 8진수 --> 0x prefix로 하면 python은 16진수로 인식 함
hex_data = 0x10
print(hex_data)

# 보통 정수형 타입의 상수 범위는 -2147483647 ~ 2147483647 이지만
# 파이썬은 최소값/최대값은 존재하지 않고, 메모리가 허용되는 범위에서 지원 가능한 수를 사용 합니다.
long_data = 1234567890123456789
print(long_data)


# 참고
# 컴퓨터에 기록되는 최소 단위는 8bit 또는 1바이트
# 1비트는 한 자리 2진수이므로 8비트는 8자리 2진수 표현
# 8진수는 3자리 2진수를 한 자리로 표현 가능
# 16진수는 4자리 2진수를 한 자리 수로 표현 가능
# 대부분의 컴퓨터에 기록 되니 데이터는 16진수로 표현이 가능
