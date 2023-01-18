from typing import List


def solution(array: List[int], height: int):
    return len(list(filter(lambda num: num > height, array)))

