from math import sqrt


def solution(n):
    float_sqrt = sqrt(n)
    int_sqrt = int(float_sqrt)

    return (int_sqrt + 1) ** 2 if float_sqrt == int_sqrt else -1
