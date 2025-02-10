from collections import deque


def solution(people, limit):
    dq = deque(sorted(people))

    answer = 0
    while dq:
        answer += 1
        big = dq.pop()

        if dq and limit - big >= dq[0]:
            dq.popleft()

    return answer
