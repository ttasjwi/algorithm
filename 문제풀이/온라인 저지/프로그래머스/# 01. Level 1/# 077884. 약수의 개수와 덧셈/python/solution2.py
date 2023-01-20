from math import sqrt


def solution(left, right):
    return sum(i if sqrt(i) % 1 else -i
               for i in range(left, right + 1))
