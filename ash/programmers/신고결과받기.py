# coding=utf-8
'''
id_list = ["muzi", "frodo", "apeach", "neo"]
report = ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]
k = 2
result = [2,1,1,0]
'''

user_list = ["muzi", "frodo", "apeach", "neo"]
report = ["muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"]
k = 2

import collections

# user_list = ["con", "ryan"]
# report = ["ryan con", "ryan con", "ryan con", "ryan con"]
# k = 3


def solution(id_list, report, k):
    answer = []
    id_list_dict = {id: 0 for id in id_list}
    user_danger = collections.defaultdict(list)
    suspended_id = collections.defaultdict(list)

    for r in report:
        if r.split()[1] not in user_danger[r.split()[0]]:
            user_danger[r.split()[0]].append(r.split()[1])

    for user_list in user_danger:
        for user in user_danger[user_list]:
            id_list_dict[user] += 1
    for user in id_list:
        for u in user_danger[user]:
            if k <= id_list_dict[u]:
                suspended_id[user].append(u)
    for id in id_list:
        if id in suspended_id:
            answer.append(len(suspended_id[id]))
        else:
            answer.append(0)

    return answer


print(solution(user_list, report, k))

'''
다른사람 베스트 풀이
'''


def solution(id_list, report, k):
    answer = [0] * len(id_list)  # id_list 만큼 길이를 만든다.
    reports = {x: 0 for x in id_list}  # id_list 로 미리 보고된 object 를 만든다.

    for r in set(report):  # set로 중복제거
        reports[r.split()[1]] += 1

    for r in set(report):
        if reports[r.split()[1]] >= k:
            answer[id_list.index(r.split()[0])] += 1

    return answer

print(solution(user_list, report, k))

'''
다른사람의 코드를 봤는데... 너무 깔끔했다....할말을 잃음
'''