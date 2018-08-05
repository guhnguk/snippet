#!/usr/bin/env python
#-*- coding: utf-8 -*-

strdata1 = '나는 데이터 분석가'
strdata2 = 'You are a data analyst'
strdata3 = """I love
    python. You love
python tool
"""

strdata4 = "My son's name is Joshua"
strdata5 = '문자열 "abc"의 길이는 3입니다'

print(strdata1)
print(strdata2)
print(strdata3)
print(strdata4)
print(strdata5)

print("-------------------------------------------")
a = "Hello, world! \t\t\n".strip()
print(a)

a = "Hello, world!".split(" ")
print(a)

a = "www.google.com".split(".")
print(a)

a = ", ".join(["alpha", "bravo", "charlie", "delta"])
print(a)

a = "-".join("123.456.789".split("."))
print(a)

a = "This string\n\r has many\t\tspaces"
print(a)
a = a.split()
print(a)
a = " ".join(a)
print(a)

print("-------------------------------------------")
a = "www.networksciencelab.com".find(".com")
print(a)

cnt = "www.networksciencelab.com".count(".")
print(cnt)