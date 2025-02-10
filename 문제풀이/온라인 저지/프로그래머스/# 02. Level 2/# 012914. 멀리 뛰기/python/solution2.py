def solution(n):
    a, b = 1, 1
    for _ in range(n):
        a, b = b, (a+b)%1234567
    return a
