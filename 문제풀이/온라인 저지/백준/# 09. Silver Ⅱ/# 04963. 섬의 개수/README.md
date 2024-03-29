# 문제
- 플랫폼 : 백준
- 번호 : 04963
- 제목 : 섬의 개수
- 난이도 : Silver 2
- 각 테스트 케이스에 대해서, 섬의 개수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/4963" target="_blank">링크</a>

---

# 필요 알고리즘
- DFS(깊이 우선 탐색)
- BFS(너비 우선 탐색)

---

# 풀이

## 풀이1 : DFS(내 풀이)
```python
import io, os, sys

sys.setrecursionlimit(10 ** 6)
input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
print = sys.stdout.write

DIRECTIONS = [(0, 1), (1, 1), (1, 0), (1, -1), (0, -1), (-1, -1), (-1, 0), (-1, 1)]

w = 0
h = 0
board = []
results = []
count = 0


def main():
    global w, h, board
    while True:
        w, h = map(int, input().decode().split())

        if w == h == 0:
            break

        board = [[int(i) for i in input().decode().split()] for _ in range(0, h)]
        process()

    print('\n'.join(results))


def process():
    global count

    count = 0
    for r in range(0, h):
        for c in range(0, w):
            if board[r][c] == 1:
                count += 1
                board[r][c] = 0
                dfs(r, c)
    results.append(str(count))


def dfs(r: int, c: int):
    for direction in DIRECTIONS:
        nr = r + direction[0]
        nc = c + direction[1]

        if (0 <= nr < h) and (0 <= nc < w) and board[nr][nc] == 1:
            board[nr][nc] = 0
            dfs(nr, nc)


if __name__ == '__main__':
    main()
```
- dfs를 통해 방문한 육지는 바다로 바꿔가면서 풀었다.

---
