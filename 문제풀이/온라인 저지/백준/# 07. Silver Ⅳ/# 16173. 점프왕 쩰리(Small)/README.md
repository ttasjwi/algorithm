# 문제
- 플랫폼 : 백준
- 번호 : 16173
- 제목 : 점프왕 쩰리(Small)
- 난이도 : Silver 4
- ‘쩰리’가 끝 점에 도달할 수 있으면 “HaruHaru”(인용부호 없이), 도달할 수 없으면 “Hing” (인용부호 없이)을 한 줄에 출력
- 문제 : <a href="https://www.acmicpc.net/problem/16173" target="_blank">링크</a>

---

# 필요 지식
- DFS
- BFS

---

# 풀이
```python
import sys

src = sys.stdin.buffer
direction = [(0, 1), (1, 0)]

n = int(src.readline())
board = [list(map(int, line.split())) for line in src.read().splitlines()]


def dfs():
    stack = [(0, 0)]
    check = [[False] * n for _ in range(n)]
    check[0][0] = True

    while stack:
        r, c = stack.pop()
        dis = board[r][c]
        for dr, dc in direction:
            nr, nc = r + dr * dis, c + dc * dis

            if 0 <= nr < n and 0 <= nc < n and not check[nr][nc]:
                if nr == n - 1 and nc == n - 1:
                    return True
                check[nr][nc] = True
                stack.append((nr, nc))
    return False


print('HaruHaru' if dfs() else 'Hing')
```
- DFS를 통해 인접 방향으로 해당 칸의 거리만큼 이동해가면서 탐색했다.
  - 다음으로 이동할 위치가 범위 밖이면 스킵
  - 다음으로 이동할 위치가 방문 안 한 범위 안이면 이어서 탐색
    - 그런데 다음으로 이동할 위치가 종점이면 거기서 탐색이 끝났으므로 True 반환
---
