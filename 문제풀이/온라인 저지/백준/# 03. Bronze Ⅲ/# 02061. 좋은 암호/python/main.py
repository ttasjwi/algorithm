import sys


def solution(k, l):
    # K의 가장 작은 인수를 찾기 위해 2부터 시작
    for i in range(2, int(l)):
        if k % i == 0:
            return f"BAD {i}"

    return "GOOD"


k, l = map(int, sys.stdin.readline().split())
answer = solution(k, l)
print(answer)
