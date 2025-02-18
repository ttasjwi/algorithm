from collections import deque

def solution(maps):
    directions = [(1, 0), (0, 1), (-1, 0), (0, -1)]
    queue = deque()
    queue.append((0, 0))
    maps[0][0] = -1
    m = len(maps)
    n = len(maps[0])

    level = 0
    while queue:
        size = len(queue)
        level += 1
        while size:
            r, c = queue.popleft()
            size -= 1

            for d in directions:
                nr, nc = r + d[0], c + d[1]
                if 0 <= nr < m and 0 <= nc < n and maps[nr][nc] == 1:
                    maps[nr][nc] = -1
                    queue.append((nr, nc))
                    if nr == m - 1 and nc == n - 1:
                        return level + 1
    return -1
