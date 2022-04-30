# coding=utf-8
"""
s	                result
"one4seveneight"	1478
"23four5six7"	    234567
"2three45sixseven"	234567
"123"	            123

숫자	영단어
0	zero
1	one
2	two
3	three
4	four
5	five
6	six
7	seven
8	eight
9	nine
"""

import re


def solution(s):
    number_list = [
        'zero', 'one', 'two', 'three',
        'four', 'five', 'six', 'seven',
        'eight', 'nine'
    ]

    if s.isdigit():
        return int(s)

    for index, number in enumerate(number_list):
        s = s.replace(number, str(index))

    return int(s)


s = "14oneeight"
print(solution(s))
