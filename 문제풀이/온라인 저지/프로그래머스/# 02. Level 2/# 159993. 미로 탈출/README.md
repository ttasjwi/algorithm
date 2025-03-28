# 문제
- 플랫폼 : 프로그래머스
- 번호 : 159993
- 제목 : 미로 탈출
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/159993" target="_blank">링크</a>

---

# 필요 지식
- BFS

---

# 풀이
```python
from collections import deque

directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]


def solution(maps):
    start = None
    lever = None
    end = None

    width = len(maps[0])
    height = len(maps)

    def bfs(start, end):
        check = [[False for _ in range(width)] for _ in range(height)]
        queue = deque([start])
        cost = -1
        check[start[0]][start[1]] = True
        while queue:
            cost += 1
            for _ in range(len(queue)):
                r, c = queue.popleft()

                for dr, dc in directions:
                    nr, nc = r + dr, c + dc
                    if 0 <= nr < height and 0 <= nc < width and maps[nr][nc] != 'X' and not check[nr][nc]:
                        if nr == end[0] and nc == end[1]:
                            return cost + 1
                        check[nr][nc] = True
                        queue.append((nr, nc))
        return -1

    for r in range(len(maps)):
        for c in range(len(maps[0])):
            if maps[r][c] == 'S':
                start = (r, c)
            elif maps[r][c] == 'L':
                lever = (r, c)
            elif maps[r][c] == 'E':
                end = (r, c)

    cost1 = bfs(start, lever)

    if cost1 == -1:
        return -1

    cost2 = bfs(lever, end)

    if cost2 == -1:
        return -1

    return cost1 + cost2
```
- 레버에 도달하는 최단 시간, 종점에 도갈하는 최단 시간을 각각 구해서 더하기

---
