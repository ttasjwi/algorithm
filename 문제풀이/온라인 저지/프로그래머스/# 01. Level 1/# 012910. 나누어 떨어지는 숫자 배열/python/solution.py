def solution(arr, divisor):
    arr = [i for i in arr if i % divisor == 0]
    return sorted(arr) if arr else [-1]
