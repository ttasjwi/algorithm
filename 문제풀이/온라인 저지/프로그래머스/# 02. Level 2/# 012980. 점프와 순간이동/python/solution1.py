def solution(n):
    answer = 0
    while n:
        if not n % 2:
            n >>= 1
        else:
            answer += 1
            n -= 1
    return answer
