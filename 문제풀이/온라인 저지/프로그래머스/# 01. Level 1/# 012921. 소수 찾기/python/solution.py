from math import sqrt


def solution(n):
    check = [False, True] + [False] * (n - 1)
    for i in range(2, int(sqrt(n)) + 1):
        if not check[i]:
            for j in range(2 * i, n + 1, i):
                check[j] = True
    return len([c for c in check[1:] if not c])
