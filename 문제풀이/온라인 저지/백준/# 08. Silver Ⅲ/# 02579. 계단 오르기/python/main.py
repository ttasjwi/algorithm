import sys

input = sys.stdin.readline
print = sys.stdout.write

n = int(input())
nums = [0] + [int(input()) for _ in range(n)]
dp = [0] * (n+1)

for i in range(1, n+1):
    if i == 1:
        dp[i] = nums[1]
    elif i == 2:
        dp[i] = nums[1] + nums[2]
    else:
        dp[i] = max(dp[i-3] + nums[i-1], dp[i-2]) + nums[i]
print(str(dp[n]))
