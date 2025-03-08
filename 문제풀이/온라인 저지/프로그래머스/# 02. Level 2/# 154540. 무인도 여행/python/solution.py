directions = [(1, 0), (0, 1), (-1, 0), (0, -1)]


def solution(maps):
    maps = [list(map) for map in maps]
    result = []

    def dfs(r, c, maps):
        stack = [(r, c)]
        day = int(maps[r][c])
        maps[r][c] = 'X'

        while stack:
            cr, cc = stack.pop()
            for dr, dc in directions:
                nr, nc = cr + dr, cc + dc

                if 0 <= nr < len(maps) and 0 <= nc < len(maps[0]) and maps[nr][nc] != 'X':
                    day += int(maps[nr][nc])
                    maps[nr][nc] = 'X'
                    stack.append((nr, nc))
        return day

    for r in range(len(maps)):
        for c in range(len(maps[0])):
            if maps[r][c] != 'X':
                day = dfs(r, c, maps)
                result.append(day)
    return [-1] if not result else sorted(result)
