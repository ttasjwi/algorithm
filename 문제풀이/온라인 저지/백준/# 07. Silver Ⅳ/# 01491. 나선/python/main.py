# 동, 북, 서, 남
d = [(1, 0), (0, 1), (-1, 0), (0, -1)]

n, m = map(int, input().split())
visited = [[0] * n for _ in range(m)]

cx, cy = 0, 0
di = 0


def get_next(cx, cy, di):
    return cx + d[di][0], cy + d[di][1]


def passable(cx, cy, di):
    nx, ny = get_next(cx, cy, di)
    return 0 <= nx < n and 0 <= ny < m and visited[ny][nx] == 0


while True:
    visited[cy][cx] = True
    if passable(cx, cy, di):
        cx, cy = get_next(cx, cy, di)
    else:
        di = (di + 1) % 4
        if not passable(cx, cy, di):
            break
print(cx, cy, sep=' ')
