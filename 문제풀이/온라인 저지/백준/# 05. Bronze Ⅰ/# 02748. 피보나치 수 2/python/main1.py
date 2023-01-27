dp = [0, 1]

def main():
    answer = pibo(int(input()))
    print(answer, end='')


def pibo(n):
    if len(dp) >= n+1:
        return dp[n]
    result = pibo(n-1) + pibo(n-2)
    dp.append(result)
    return result


if __name__ == '__main__':
    main()
