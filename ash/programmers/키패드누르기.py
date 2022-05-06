# coding=utf-8
"""
numbers	                            hand	        result
[1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]	"right"	        "LRLLLRLLRRL"
[7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]	"left"	        "LRLLRRLLLRR"
[1, 2, 3, 4, 5, 6, 7, 8, 9, 0]	    "right"	        "LLRLLRLLRL"
"""


def solution(numbers, hand):
    answer = ''

    # 키패드 좌표료 변경
    phone_number = {1: [0, 0], 2: [0, 1], 3: [0, 2],
                    4: [1, 0], 5: [1, 1], 6: [1, 2],
                    7: [2, 0], 8: [2, 1], 9: [2, 2],
                    '*': [3, 0], 0: [3, 1], '#': [3, 2]}

    # 시작 위치
    current_left = phone_number['*']
    current_right = phone_number['#']

    for i in numbers:
        now = phone_number[i]
        if i in [1, 4, 7]:
            answer += 'L'
            current_left = now

        elif i in [3, 6, 9]:
            answer += 'R'
            current_right = now

        # 2, 5, 8, 0을 누르는 경우
        else:
            left_diff = 0
            right_diff = 0

            # 좌표 거리 계산해주기

            for left, right, current in zip(current_left, current_right, now):
                left_diff += abs(left - current)
                right_diff += abs(right - current)

            # 왼손이 더 가까운 경우
            if left_diff < right_diff:
                answer += 'L'
                current_left = now

            # 오른손이 더 가까운 경우
            elif left_diff > right_diff:
                answer += 'R'
                current_right = now

            # 두 거리가 같은 경우
            else:
                # 왼손잡이 경우
                if hand == 'left':
                    answer += 'L'
                    current_left = now
                else:
                    answer += 'R'
                    current_right = now

    return answer


numbers = [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]
hand = "right"
print(solution(numbers, hand))
