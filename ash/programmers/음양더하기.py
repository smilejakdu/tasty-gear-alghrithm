"""
absolutes	signs	result
[4,7,12]	[true,false,true]	9
[1,2,3]	[false,false,true]	0
"""


def solution(absolutes, signs):
    number = 0
    for a, s in zip(absolutes, signs):
        number += a if s == True else -a
    return number


absolutes = [4, 7, 12]
signs = [True, False, True]
print(solution(absolutes, signs))

'''
다른사람 풀이
'''


def solution(absolutes, signs):
    return sum(absolutes if sign else -absolutes for absolutes, sign in zip(absolutes, signs))
