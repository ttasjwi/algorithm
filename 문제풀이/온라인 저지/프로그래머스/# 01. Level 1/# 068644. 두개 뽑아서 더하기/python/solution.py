from itertools import combinations


def solution(numbers):
    return sorted(list({sum(comb) for comb in combinations(numbers, 2)}))
