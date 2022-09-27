import sys

dp = [[None for _ in range(30)] for _ in range(30)]


def main():
    _ = input()
    for line in sys.stdin:
        n, m = map(int, line.split())
        print(comb(m, n))


def comb(m: int, n: int) -> int:
    if not dp[m][n] is None:
        return dp[m][n]
    if n == 0 or n == m:
        dp[m][n] = 1
        dp[m][m - n] = 1
        return dp[m][n]
    if n == 1 or n == m - 1:
        dp[m][n] = m
        dp[m][m - n] = m
        return dp[m][n]
    dp[m][n] = comb(m - 1, n - 1) + comb(m - 1, n)
    dp[m][m - n] = dp[m][n]
    return dp[m][n]


main()
