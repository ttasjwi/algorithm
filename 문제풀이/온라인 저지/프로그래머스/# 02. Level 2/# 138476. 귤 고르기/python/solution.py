from collections import Counter

def solution(k, tangerine):
    counter = Counter(tangerine)
    answer = 0
    for value in sorted(counter.values(), reverse=True):
        answer += 1
        k -= value
        if k <= 0:
            return answer
