from typing import List


def solution(arr:List[int]):
    arr.remove(min(arr))
    return arr if arr else [-1]

