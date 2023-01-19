from collections import Counter


def solution(s):
    return ''.join(sorted([key for key, value in Counter(s).items() if value == 1]))

