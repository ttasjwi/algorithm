from collections import Counter


def solution(s: str):
    counter = Counter(s.lower())
    return counter['p'] == counter['y']
