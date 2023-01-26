m,n = map(int, input().split())

check = [False, True] + [False] * (n-1)

for i in range(2, n+1):
    if not check[i]:
        for j in range(2*i, n+1, i):
            check[j] = True

answer = '\n'.join(str(i) for i in range(m, n+1) if not check[i])
print(answer, end='')
