'''
lottos	win_nums	result
[44, 1, 0, 0, 31, 25]	[31, 10, 45, 1, 6, 19]	[3, 5]
[0, 0, 0, 0, 0, 0]	[38, 19, 20, 40, 15, 25]	[1, 6]
[45, 4, 35, 20, 3, 9]	[20, 9, 3, 45, 4, 35]	[1, 1]
'''


def solution(lottos, win_nums):
    ranking = {
        6: 1,
        5: 2,
        4: 3,
        3: 4,
        2: 5,
    }
    best = 0
    worst = 0

    for lotto in lottos:
        if lotto == 0:
            best += 1
        elif lotto in win_nums:
            best += 1
            worst += 1

    return [6 if best < 2 else ranking[best], 6 if worst < 2 else ranking[worst]]


lottos = [44, 1, 0, 0, 31, 25]
win_nums = [31, 10, 45, 1, 6, 19]

print(solution(lottos, win_nums))
