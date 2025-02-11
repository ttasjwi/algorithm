from collections import Counter

def solution(clothes):
    counter = Counter([kind for _, kind in clothes])
    answer = 1
    for v in counter.values():
        answer *= (v + 1)
    return answer - 1
