# 문제
- 플랫폼 : 백준
- 번호 : 02583
- 제목 : 영역 구하기
- 난이도 : Silver 1
- 첫째 줄에 분리되어 나누어지는 영역의 개수를 출력, 둘째 줄에는 각 영역의 넓이를 오름차순으로 정렬하여 빈칸을 사이에 두고 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2583" target="_blank">링크</a>

---

# 필요 알고리즘
- DFS
- BFS

---

# 풀이
## 풀이1 : BFS
```python
import sys

input = sys.stdin.readline
print = sys.stdout.write


def main():
    m, n, k = map(int, input().split())
    board = [[1] * n for _ in range(m)]
    for _ in range(k):
        x1, y1, x2, y2 = map(int, input().split())
        for y in range(y1, y2):
            for x in range(x1, x2):
                board[y][x] = 0

    directions = [(1, 0), (0, -1), (-1, 0), (0, 1)]

    q = []
    cnt = 0
    areas = []
    for y in range(0, m):
        for x in range(0, n):
            if board[y][x] == 1:
                cnt += 1
                board[y][x] = 0
                q.append((x, y))
                area = 0
                while q:
                    cx, cy = q.pop(0)
                    area += 1
                    for dx, dy in directions:
                        nx, ny = cx + dx, cy + dy
                        if 0 <= nx < n and 0 <= ny < m and board[ny][nx] == 1:
                            board[ny][nx] = 0
                            q.append((nx, ny))
                areas.append(area)
    print(str(cnt) + '\n')
    print(' '.join(map(str, sorted(areas))))


if __name__ == '__main__':
    main()
```
- 리스트를 큐로 사용하여, BFS를 수행했다.


## 풀이2: DFS
```python
import sys

input = sys.stdin.readline
print = sys.stdout.write


def main():
    m, n, k = map(int, input().split())
    board = [[1] * n for _ in range(m)]
    for _ in range(k):
        x1, y1, x2, y2 = map(int, input().split())
        for y in range(y1, y2):
            for x in range(x1, x2):
                board[y][x] = 0

    directions = [(1, 0), (0, -1), (-1, 0), (0, 1)]

    s = []
    cnt = 0
    areas = []
    for y in range(0, m):
        for x in range(0, n):
            if board[y][x] == 1:
                cnt += 1
                board[y][x] = 0
                s.append((x, y))
                area = 0
                while s:
                    cx, cy = s.pop()
                    area += 1
                    for dx, dy in directions:
                        nx, ny = cx + dx, cy + dy
                        if 0 <= nx < n and 0 <= ny < m and board[ny][nx] == 1:
                            board[ny][nx] = 0
                            s.append((nx, ny))
                areas.append(area)
    print(str(cnt) + '\n')
    print(' '.join(map(str, sorted(areas))))


if __name__ == '__main__':
    main()
```
- 스택을 이용하여 DFS를 구현했다.

---
