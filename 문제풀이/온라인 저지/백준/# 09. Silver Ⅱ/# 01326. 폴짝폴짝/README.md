# 문제
- 플랫폼 : 백준
- 번호 : 01326
- 제목 : 폴짝폴짝
- 난이도 : Silver 2
- 개구리가 a번 징검다리에서 b번 징검다리로 최소 몇 번 점프하여 갈 수 있는 지를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1326" target="_blank">링크</a>

---

# 필요 지식
- bfs

---

# 풀이
```python
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
```
- 왼쪽 방향, 오른쪽 방향 모두를 탐색해야한다.
- 다시 한번 방문했던 위치를 방문하지 않도록 각각의 비용을 별도로 저장하고 비용이 0이상일 떄는 다시 따지지 않는다.

---
