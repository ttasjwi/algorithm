def solution(a, b):
    a, b = (a, b) if (a <= b) else (b, a)
    return sum([i for i in range(a, b+1)])

