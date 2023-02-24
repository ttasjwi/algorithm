import sys

print = sys.stdout.write

n, m = map(int, input().split())
nums = [-1] * m
check = [False] * (n + 1)


def dfs(idx):
    if idx == m:
        print(' '.join(map(str, nums)))
        print('\n')
        return
    for num in range(1, n + 1):
        if not check[num]:
            check[num] = True
            nums[idx] = num
            dfs(idx + 1)
            check[num] = False


dfs(0)
