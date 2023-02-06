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
