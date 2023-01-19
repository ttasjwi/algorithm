from math import sqrt


def solution(n):
    sqrt_n = sqrt(n)
    return 1 if sqrt_n == int(sqrt_n) else 2
