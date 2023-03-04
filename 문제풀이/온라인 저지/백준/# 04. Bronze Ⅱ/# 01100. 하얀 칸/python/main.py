import sys

board = [list(line.rstrip()) for line in sys.stdin.read().splitlines()]
cnt = 0

for i in range(8):
    for j in range(8):
        if ((i % 2 == 0 and j % 2 == 0) or (i % 2 != 0 and j % 2 != 0)) and board[i][j] == 'F':
            cnt += 1
print(cnt)
