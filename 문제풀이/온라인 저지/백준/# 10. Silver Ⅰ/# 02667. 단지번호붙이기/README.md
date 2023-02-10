# 문제
- 플랫폼 : 백준
- 번호 : 02667
- 제목 : 단지번호붙이기
- 난이도 : Silver 1
- 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2667" target="_blank">링크</a>

---

# 필요 알고리즘
- DFS

---

# 풀이
```python
import sys

input = sys.stdin.readline
n = int(input())

directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
board = [list(input().rstrip()) for _ in range(n)]
count = 0
nums = []
s = []
for i in range(n):
    for j in range(n):
        if board[i][j] == '1':
            count += 1
            num = 0
            s.append((i, j))
            board[i][j] = '0'
            while s:
                r, c = s.pop()
                num += 1
                for dr, dc in directions:
                    nr, nc = r + dr, c + dc
                    if 0 <= nr < n and 0 <= nc < n and board[nr][nc] == '1':
                        board[nr][nc] = '0'
                        s.append((nr, nc))
            nums.append(num)
print(count)
print('\n'.join(map(str, sorted(nums))))
```
- DFS를 통해 연결된 단지수를 세고, 연결된 집의 수를 카운팅한다.
- 여기서는 스택을 이용해 DFS를 구현했다.
- BFS를 이용해 이 문제를 풀어도 된다.

---
