from collections import deque


def solution(queue1, queue2):
    sum1 = sum(queue1)
    sum2 = sum(queue2)

    size = len(queue1)

    queue1 = deque(queue1)
    queue2 = deque(queue2)

    for answer in range(size * 4):
        if sum1 > sum2:
            left = queue1.popleft()
            queue2.append(left)
            sum1 -= left
            sum2 += left
        elif sum1 < sum2:
            left = queue2.popleft()
            queue1.append(left)
            sum2 -= left
            sum1 += left
        else:
            return answer
    return -1
