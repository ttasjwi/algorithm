def solution(n):
    return ''.join(['수박'[i % 2] for i in range(n)])
