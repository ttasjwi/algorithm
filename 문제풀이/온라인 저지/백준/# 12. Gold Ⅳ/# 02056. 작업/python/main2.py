import sys

input = sys.stdin.buffer.readline

n = int(input())
dp = [0] * (n + 1)

for i in range(n):
    line = list(map(int, input().split()))
    if line[1]:
        dp[i + 1] = max(dp[x] for x in line[2:]) + line[0]
    else:
        dp[i + 1] = line[0]

print(max(dp))
