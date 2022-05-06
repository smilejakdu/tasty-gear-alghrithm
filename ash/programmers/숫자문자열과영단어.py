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

s = 'one4seveneight'


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

'''
다른사람 풀이
아래처럼 풀려고 했는데,
다시 생각해보면 ... list 라는것이 index 가 있으니 , 
zero 는 index 0 
one 은 index 1 
으로 하면 되지않을까?? 생각을 해서 저는 list 로 풀었습니다.

알고리즘 공부하면서 느끼는건데... 신기한게 생각하는게 다 비슷비슷한게 신기하네요
'''

num_dic = {"zero": "0", "one": "1", "two": "2", "three": "3", "four": "4", "five": "5", "six": "6", "seven": "7",
           "eight": "8", "nine": "9"}


def solution(s):
    answer = s
    for key, value in num_dic.items():
        answer = answer.replace(key, value)
    return int(answer)
