from math import sqrt

input()
nums = [int(s[::-1]) for s in input().split()]
mx = max(nums)

check = [True, True] + [False] * (mx - 1)
for i in range(2, int(sqrt(mx)) + 1):
    if not check[i]:
        for j in range(2 * i, mx + 1, i):
            check[j] = True

print(' '.join(str(num) for num in nums if not check[num]), end='')
