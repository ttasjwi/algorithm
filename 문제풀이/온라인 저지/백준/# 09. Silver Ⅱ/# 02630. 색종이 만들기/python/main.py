import sys

src = sys.stdin.buffer
n = int(src.readline())
board = [[*map(int, line.split())] for line in src.read().splitlines()]
counts = [0, 0]


def counting(r, c, length):
    start_color = board[r][c]
    for i in range(r, r + length):
        for j in range(c, c + length):
            if board[i][j] != start_color:
                next_length = length // 2
                counting(r, c, next_length)
                counting(r + next_length, c, next_length)
                counting(r, c + next_length, next_length)
                counting(r + next_length, c + next_length, next_length)
                return
    counts[start_color] += 1


counting(0, 0, n)
print('\n'.join(map(str, counts)), end='')
