import sys

src = sys.stdin.buffer
direction = [(0, 1), (1, 0)]

n = int(src.readline())
board = [list(map(int, line.split())) for line in src.read().splitlines()]


def dfs():
    stack = [(0, 0)]
    check = [[False] * n for _ in range(n)]
    check[0][0] = True

    while stack:
        r, c = stack.pop()
        dis = board[r][c]
        for dr, dc in direction:
            nr, nc = r + dr * dis, c + dc * dis

            if 0 <= nr < n and 0 <= nc < n and not check[nr][nc]:
                if nr == n - 1 and nc == n - 1:
                    return True
                check[nr][nc] = True
                stack.append((nr, nc))
    return False


print('HaruHaru' if dfs() else 'Hing')
