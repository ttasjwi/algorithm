# 문제
- 플랫폼 : LeetCode
- 번호 : 0200
- 제목 : Number of Island
- 난이도 : Medium
- 지도의 '1'은 육지이고, '0'은 바다이다. '1'이 수평 또는 수직으로 연결되어 있으면 같은 섬으로 볼 때, 육지의 갯수를
반환하라.
- 문제 : <a href="https://leetcode.com/problems/number-of-islands" target="_blank">링크</a>

---

# 필요 지식
- DFS(깊이 우선 탐색)
- BFS(너비 우선 탐색)

---

# 풀이
## 풀이1: DFS 재귀함수 구현
```python
from typing import List


class Solution:

    def numIslands(self, grid: List[List[str]]) -> int:
        direction = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        cnt = 0

        def dfs(i: int, j: int) -> None:
            grid[i][j] = '0'
            for r, c in direction:
                nr, nc = i + r, j + c
                if 0 <= nr < len(grid) and 0 <= nc < len(grid[0]) and grid[nr][nc] == '1':
                    dfs(nr, nc)

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    dfs(i, j)
                    cnt += 1
        return cnt
```

## 풀이2: DFS 스택 구현
```python
from typing import List


class Solution:

    def numIslands(self, grid: List[List[str]]) -> int:
        direction = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        cnt = 0

        stack = []
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    stack.append((i, j))
                    while stack:
                        r, c = stack.pop()
                        grid[r][c] = '0'
                        for dr, dc in direction:
                            nr, nc = r + dr, c + dc
                            if 0 <= nr < len(grid) and 0 <= nc < len(grid[0]) and grid[nr][nc] == '1':
                                stack.append((nr, nc))
                    cnt += 1
        return cnt
```

## 풀이3 : BFS
```python
from collections import deque
from typing import List


class Solution:

    def numIslands(self, grid: List[List[str]]) -> int:
        direction = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        cnt = 0
        q = deque()

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    grid[i][j] = '0'
                    q.append((i, j))
                    while q:
                        r, c = q.popleft()
                        for dr, dc in direction:
                            nr, nc = r + dr, c + dc
                            if 0 <= nr < len(grid) and 0 <= nc < len(grid[0]) and grid[nr][nc] == '1':
                                grid[nr][nc] = '0'
                                q.append((nr, nc))
                    cnt += 1
        return cnt
```

---
