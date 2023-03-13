import sys

src = sys.stdin.buffer
n = int(src.readline())
board = [list(map(int, line.split())) for line in src.read().splitlines()]

dp = [[0] * n for _ in range(n)]
dp[0][0] = 1

for i in range(n):
    for j in range(n):
        if board[i][j] == 0:
            continue
        dis = board[i][j]
        if i + dis < n:
            dp[i + dis][j] += dp[i][j]
        if j + dis < n:
            dp[i][j + dis] += dp[i][j]
print(dp[n - 1][n - 1])
