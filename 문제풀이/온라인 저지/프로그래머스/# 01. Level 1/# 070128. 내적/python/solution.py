def solution(numbers_a, numbers_b):
    return sum(a * b for a, b in zip(numbers_a, numbers_b))
