from typing import List


def solution(array:List[int]):
    max_value = max(array)
    index = array.index(max_value)
    return [max_value, index]
