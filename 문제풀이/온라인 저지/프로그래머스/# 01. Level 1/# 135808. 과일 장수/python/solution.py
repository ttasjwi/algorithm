def solution(k, m, scores):
    return sum(sorted(scores)[len(scores) % m::m]) * m
