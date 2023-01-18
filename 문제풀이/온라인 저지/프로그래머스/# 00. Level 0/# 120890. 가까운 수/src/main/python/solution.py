def solution(array, n):
    return min(array, key=lambda x: (abs(n-x), x-n))

