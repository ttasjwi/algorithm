dp = [-1] * 100001


def find(n, k):
    if dp[k] >= 0:
        return dp[k]
    if n >= k:
        dp[k] = n - k
        return dp[k]
    if k == 1:
        dp[k] = 1
        return dp[k]
    if k % 2:
        dp[k] = min(find(n, k - 1), find(n, k + 1)) + 1
        return dp[k]
    dp[k] = min(k - n, find(n, k // 2) + 1)
    return dp[k]


print(find(*map(int, input().split())))
