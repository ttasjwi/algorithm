import sys
from collections import deque

input = sys.stdin.buffer.readline
n = int(input())
jump = [0] + list(map(int, input().split()))
start, end = map(int, input().split())


def bfs():
    queue = deque([start])
    costs = [-1] * 100001
    costs[start] = 0

    while queue:
        current_pos = queue.popleft()

        if jump[current_pos] == 1:
            return costs[current_pos] + 1

        for i in range(current_pos, n+1, jump[current_pos]):
            if costs[i] == -1:
                costs[i] = costs[current_pos] + 1
                queue.append(i)

                if i == end:
                    return costs[i]

        for i in range(current_pos, 0, -jump[current_pos]):
            if costs[i] == -1:
                costs[i] = costs[current_pos] + 1
                queue.append(i)

                if i == end:
                    return costs[i]

    return -1


print(bfs())
