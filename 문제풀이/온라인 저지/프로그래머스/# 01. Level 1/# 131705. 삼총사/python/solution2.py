from itertools import combinations


def solution(number):
    return len([1 for comb in combinations(number, 3) if sum(comb) == 0])
