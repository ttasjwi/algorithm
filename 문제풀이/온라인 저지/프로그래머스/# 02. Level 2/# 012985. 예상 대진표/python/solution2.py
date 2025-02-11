def solution(n, a, b):
    answer = 0
    a = a - 1
    b = b - 1
    while a != b:
        answer += 1
        a >>= 1
        b >>= 1
    return answer
