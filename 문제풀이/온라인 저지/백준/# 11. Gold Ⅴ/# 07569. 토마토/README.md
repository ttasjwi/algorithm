# 문제
- 플랫폼 : 백준
- 번호 : 07569
- 제목 : 토마토
- 난이도 : Gold 5
- 토마토가 모두 익을 때까지 최소 며칠이 걸리는지를 계산해서 출력
- 문제 : <a href="https://www.acmicpc.net/problem/7569" target="_blank">링크</a>

---

# 필요 지식
- BFS

---

# 풀이
```python
import sys
from collections import deque

input = sys.stdin.buffer.readline

direction = [(1, 0, 0), (-1, 0, 0), (0, 0, 1), (0, 1, 0), (0, 0, -1), (0, -1, 0)]
m = 0
n = 0
h = 0
cnt = 0
box = None
q = None


def main():
    get_args()
    init_queue()
    answer = bfs()
    print(answer)


def get_args():
    global m, n, h, box
    m, n, h = map(int, input().split())
    box = [[[*map(int, input().split())] for _ in range(n)] for _ in range(h)]


def init_queue():
    global q, cnt, z
    q = deque()
    cnt = 0
    for z in range(h):
        for y in range(n):
            for x in range(m):
                if box[z][y][x] == 1:
                    q.append((z, y, x))
                elif box[z][y][x] == 0:
                    cnt += 1


def bfs():
    global cnt
    max_day = -1
    while q:
        max_day += 1
        for _ in range(len(q)):
            z, r, c = q.popleft()
            for dz, dy, dx in direction:
                nz, ny, nx = z + dz, r + dy, c + dx
                if 0 <= nz < h and 0 <= ny < n and 0 <= nx < m and box[nz][ny][nx] == 0:
                    cnt -= 1
                    box[nz][ny][nx] = -1  # 방문 처리
                    q.append((nz, ny, nx))
    return -1 if cnt else max_day


main()
```
- 입력 받기
- 큐에 익은 토마토들의 위치를 삽입(이 과정에서 안 익은 토마토를 카운팅한다.)
- bfs 탐색을 하면서 max_day를 한 단계 늘려가고  인접한 안 익은 토마토를 방문처리하고 카운트를 제한다.
- 최종적으로 cnt가 0이면 안 익은 토마토가 없다는 것이고, 0보다 크면 최대 일자를 출력한다.

---
