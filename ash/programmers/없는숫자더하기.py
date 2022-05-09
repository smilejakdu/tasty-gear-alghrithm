"""
numbers	            result
[1,2,3,4,6,7,8,0]	14
[5,8,4,0,6,7,9] 	6
"""


def solution(numbers):
    except_number = []
    check_number = [i for i in range(0, 10)]

    for num in check_number:
        if num not in numbers:
            except_number.append(num)

    return sum(except_number)


numbers = [1, 2, 3, 4, 6, 7, 8, 0]
print(solution(numbers))

'''
다른사람풀이
'''
solution = lambda x: sum(range(10)) - sum(x)
