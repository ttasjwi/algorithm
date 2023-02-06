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