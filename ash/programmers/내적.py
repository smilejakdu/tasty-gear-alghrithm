"""
a	        b	         result
[1,2,3,4]	[-3,-1,0,2]	 3
[-1,0,1]	[1,0,-1]	-2
"""


def solution(a, b):
    return sum([a*b for a,b in zip(a,b)])


a = [1, 2, 3, 4]
b = [-3, -1, 0, 2]
print(solution(a, b))
