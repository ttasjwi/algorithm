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
