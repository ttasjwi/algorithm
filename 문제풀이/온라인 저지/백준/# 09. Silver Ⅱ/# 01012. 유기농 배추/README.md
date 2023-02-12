# 문제
- 플랫폼 : 백준
- 번호 : 01012
- 제목 : 유기농 배추
- 난이도 : Silver 2
- 각 테스트 케이스에 대해 필요한 최소의 배추흰지렁이 마리 수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1012" target="_blank">링크</a>

---

# 필요 알고리즘
- DFS
- BFS

---

# 풀이
```python
import sys

input = sys.stdin.readline
print = sys.stdout.write


def main():
    s = []
    answer = []
    direction = [(0, 1), (1, 0), (0, -1), (-1, 0)]
    for _ in range(int(input())):
        m, n, k = map(int, input().split())
        board = [[0] * m for _ in range(n)]
        for _ in range(k):
            x, y = map(int, input().split())
            board[y][x] = 1
        cnt = 0
        for i in range(n):
            for j in range(m):
                if board[i][j]:
                    board[i][j] = 0
                    cnt += 1
                    s.append((i, j))
                    while s:
                        r, c = s.pop()
                        for dr, dc in direction:
                            nr, nc = r + dr, c + dc
                            if (0 <= nr < n) and (0 <= nc < m) and board[nr][nc]:
                                board[nr][nc] = 0
                                s.append((nr, nc))
        answer.append(cnt)
    print('\n'.join(map(str, answer)))


main()
```
- 아주 전형적인 DFS/BFS를 통한 특정 조건을 만족하는 영역 갯수 구하기 문제

---
