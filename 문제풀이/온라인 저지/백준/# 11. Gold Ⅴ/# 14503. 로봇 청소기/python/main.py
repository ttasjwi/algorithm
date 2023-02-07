import sys

input = sys.stdin.readline
directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]

n, m = map(int, input().split())
r, c, d = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
answer = 0
while True:
    if board[r][c] == 0:
        board[r][c] = 2
        answer += 1
    cnt = 4
    nd = d
    while cnt > 0:
        nd = (nd - 1) % 4
        nr, nc = r + directions[nd][0], c + directions[nd][1]
        if (0 <= nr < n) and (0 <= nc < m) and board[nr][nc] == 0:
            r, c, d = nr, nc, nd
            break
        cnt -= 1
    if cnt == 0:
        nd = (d - 2) % 4
        nr, nc = r + directions[nd][0], c + directions[nd][1]
        if (0 <= nr < n) and (0 <= nc < m) and board[nr][nc] != 1:
            r, c = nr, nc
        else:
            break
print(answer, end='')
