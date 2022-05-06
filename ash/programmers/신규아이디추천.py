# coding=utf-8
import re


def solution(new_id):
    new_id = new_id.lower()  # 소문자
    new_id = re.sub('[^a-z0-9\-_.]', '', new_id)  # 소문자 , 숫자 , 빼기 , 밑줄 , 마침표 빼고 제거))
    while '..' in new_id:  # 2번이상 연속된 부분을 하나의 마침표로 치환
        new_id = new_id.replace("..", ".")
    new_id = new_id.strip(".")  # 마침표가 처음이나 끝에 위치한다면 제거
    new_id = new_id if new_id else "a"  # 빈 문자열이라면 , new_id 에 "a" 대입
    new_id = new_id[:15].strip(".")  # 16 이상이면 15개 제외 나머지 제거 끝에 마침표 제거

    if len(new_id) < 3:  # new_id 2자 이하라면
        new_id = new_id + new_id[-1] * (3 - len(new_id))  # new_id 마지막문자를 길이 3이될때까지 붙임
    return new_id
