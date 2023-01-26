from itertools import combinations
from math import sqrt


def solution(nums):
    check = [False, True] + [False] * 2999

    for i in range(2, int(sqrt(3000)) + 1):
        if not check[i]:
            for j in range(2 * i, len(check), i):
                check[j] = True

    return len([1 for comb in combinations(nums, 3) if not check[sum(comb)]])
