"""
s	                result
"one4seveneight"	1478
"23four5six7"	    234567
"2three45sixseven"	234567
"123"	            123
"""

import re


def solution(s):
    answer = 0
    strings = ''
    number = 0

    string_list = list(s)
    for string in string_list:
        if str(string).isalpha():
            print('if:', string)
        else:
            print('else if:', string)

    return answer


s = "one4seveneight"
print(solution(s))
