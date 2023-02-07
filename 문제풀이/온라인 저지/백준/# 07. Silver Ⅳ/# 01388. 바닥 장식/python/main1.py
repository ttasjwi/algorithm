import sys

input = sys.stdin.readline

n, m = map(int, input().split())
board = [list(input()) for i in range(n)]

count = 0
for r in range(n):
    for c in range(m):
        if board[r][c] == '#':
            continue
        if board[r][c] == '-':
            cur_c = c
            count += 1
            while cur_c < m and board[r][cur_c] == '-':
                board[r][cur_c] = '#'
                cur_c += 1
        if board[r][c] == '|':
            cur_r = r
            count += 1
            while cur_r < n and board[cur_r][c] == '|':
                board[cur_r][c] = '#'
                cur_r += 1

print(count, end='')
