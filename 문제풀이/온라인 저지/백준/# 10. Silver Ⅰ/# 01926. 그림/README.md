# 문제
- 플랫폼 : 백준
- 번호 : 01926
- 제목 : 그림
- 난이도 : Silver 1
- 그림이 그려져 있을 때, 그 그림의 개수와, 그 그림 중 넓이가 가장 넓은 것의 넓이를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1926" target="_blank">링크</a>

---

# 필요 알고리즘
- DFS
- BFS

---

# 풀이
```python
import sys


def main():
    input = sys.stdin.readline
    print = sys.stdout.write
    directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]

    n, m = map(int, input().split())
    board = [[int(ch) for ch in input().split()] for _ in range(n)]
    cnt = 0
    max_area = 0
    s = []
    for i in range(n):
        for j in range(m):
            if board[i][j]:
                board[i][j] = 0
                cnt += 1
                area = 1
                s.append((i, j))
                while s:
                    r, c = s.pop()
                    for dr, dc in directions:
                        nr, nc = r + dr, c + dc
                        if 0 <= nr < n and 0 <= nc < m and board[nr][nc]:
                            board[nr][nc] = 0
                            area += 1
                            s.append((nr, nc))
                if area > max_area:
                    max_area = area
    print('\n'.join((str(cnt), str(max_area))))


main()
```
- DFS를 통해서 그림의 넓이 최댓값, 갯수를 카운팅했다.
- 물론 이 문제 풀이는 BFS로도 가능하다.

---
