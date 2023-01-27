from collections import Counter
from typing import List


def solution(n: int, stages: List[int]):
    results = [[i, 0, 0] for i in range(0, n + 2)]

    for key, count in Counter(stages).items():
        results[key][1] += count
        for before in range(1, key + 1):
            results[before][2] += count

    return list(map(lambda x: x[0], sorted(results[1:-1], key=lambda x: (-x[1] / x[2] if x[2] != 0 else 0, x[0]))))

