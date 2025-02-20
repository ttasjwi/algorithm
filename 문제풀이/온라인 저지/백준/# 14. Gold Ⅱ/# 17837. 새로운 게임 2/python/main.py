import sys

input = sys.stdin.readline
print = sys.stdout.write

directions = [(0, 1), (0, -1), (-1, 0), (1, 0)]

n, k = map(int, input().split())
board = [list(map(lambda x: [int(x), []], input().split())) for _ in range(n)]
horses = [list(map(lambda x: int(x) - 1, input().split())) for _ in range(k)]
for i in range(k):
    r, c, d = horses[i]
    board[r][c][1].append(i)

turn = 1

while turn <= 1000:
    for horse_index in range(k):
        r, c, d = horses[horse_index]
        nr, nc = r + directions[d][0], c + directions[d][1]

        if (not 0 <= nr < n) or (not 0 <= nc < n) or board[nr][nc][0] == 2:
            d = d + 1 if (d % 2 == 0) else d - 1
            horses[horse_index][2] = d
            nr, nc = r + directions[d][0], c + directions[d][1]

            if (not 0 <= nr < n) or (not 0 <= nc < n) or board[nr][nc][0] == 2:
                continue

        move_horse_indices = board[r][c][1][board[r][c][1].index(horse_index):]

        if board[nr][nc][0] == 1:
            move_horse_indices.reverse()
        board[nr][nc][1] += move_horse_indices

        for move_horse_index in move_horse_indices:
            horses[move_horse_index][0] = nr
            horses[move_horse_index][1] = nc
            board[r][c][1].pop()

        if len(board[nr][nc][1]) >= 4:
            print(str(turn))
            exit(0)
    turn += 1
print('-1')
