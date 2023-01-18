from typing import List


def solution(array: List[int], height: int):
    return sum(1 for h in array if h > height)

