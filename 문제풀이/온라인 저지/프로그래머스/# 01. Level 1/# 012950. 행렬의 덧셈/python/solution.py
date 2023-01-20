def solution(arr1, arr2):
    return [[a + b for a, b in zip(x, y)] for x, y in zip(arr1, arr2)]
