from math import sqrt

n = int(input())
check = [True, True] + [False] * (n - 1)

for i in range(2, int(sqrt(n)) + 1):
    if not check[i]:
        for j in range(2 * i, n + 1, i):
            check[j] = True
print(check.count(False), end='')
