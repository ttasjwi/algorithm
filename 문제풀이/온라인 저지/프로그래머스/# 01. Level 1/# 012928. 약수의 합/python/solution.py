from math import sqrt


def solution(n):
    answer = 0
    for i in range(1, int(sqrt(n)) + 1):
        if n%i == 0:
            answer += i
            if i != n//i:
                answer += n//i

    return answer
