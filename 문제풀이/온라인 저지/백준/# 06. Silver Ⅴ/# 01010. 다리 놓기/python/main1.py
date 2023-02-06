import sys

input = sys.stdin.readline
print = sys.stdout.write


def main():
    answer = []
    dp = [[0] * (k + 1) for k in range(30)]

    for m in range(30):
        for n in range(0, m // 2 + 1):
            if n == 0:
                dp[m][0] = dp[m][m] = 1
            elif n == 1:
                dp[m][1] = dp[m][m - 1] = m
            else:
                dp[m][n] = dp[m][m - n] = dp[m - 1][n - 1] + dp[m - 1][n]

    for _ in range(int(input())):
        n, m = map(int, input().split())
        answer.append(str(dp[m][n]))
    print('\n'.join(answer))


if __name__ == '__main__':
    main()
