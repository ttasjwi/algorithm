# 문제
- 플랫폼 : 백준
- 번호 : 02178
- 제목 : 미로 탐색
- 난이도 : Silver 1
- 미로의 (1,1)에서 (N,M)까지 지나야 하는 최소의 칸 수를 구하기
- 문제 : <a href="https://www.acmicpc.net/problem/2178" target="_blank">링크</a>

---

# 필요 알고리즘
- BFS(너비 우서 탐색)

---

## 풀이
```python
import io, os, sys

directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]

input = sys.stdin.readline
print = sys.stdout.write


def bfs():
    queue = [(0, 0)]
    board[0][0] = 0
    level = 0

    while queue:
        size = len(queue)
        level += 1
        for _ in range(size):
            current = queue.pop(0)
            r, c = current[0], current[1]
            for direction in directions:
                nr, nc = r + direction[0], c + direction[1]
                if 0 <= nr < len(board) and 0 <= nc < len(board[0]) and board[nr][nc] == '1':
                    if nr == n - 1 and nc == m - 1:
                        return str(level + 1)
                    board[nr][nc] = '0'
                    queue.append((nr, nc))


n, m = map(int, input().split())
board = [list(input().rstrip()) for _ in range(n)]
print(bfs())
```
- 목적지까지의 거리를 구할 때 가능한 빨리 찾아내는 것이 중요하므로 BFS를 통해 탐색한다.
- 다음을 큐가 빌 때까지 반복한다.
  - 큐의 요소 수를 세고, level을 증가시킨다. 요소의 수 만큼 다음을 반복한다.
  - 큐에서 요소를 꺼낸다.
  - 사방을 탐색하여, 갈 수 있는 곳들 중 안 간 곳을 찾는다.
    - 목적지이면 여기서 탈출한다.(level +1)
  - 위치를 큐에 삽입하고, 해당 위치를 갈 수 없는 곳으로 마킹한다.

---
