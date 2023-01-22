from typing import List


def solution(n: int, arr1: List[int], arr2: List[int]):
    return [get_password(a, b, n) for a, b in zip(arr1, arr2)]


def get_password(a, b, n):
    password = bin(a | b)[2:]
    password = password.rjust(n, '0')  # 오른쪽 정렬(빈 자리는 '0'으로 변환)
    password = password.replace('0', ' ')  # '0'을 ' ' 으로 변환
    password = password.replace('1', '#')  # '1'을 '#' 으로 변환
    return password
