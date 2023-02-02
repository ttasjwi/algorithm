n, k = map(int, input().split())
q = [i for i in range(1, n+1)]
result = []
idx = 0
while q:
    idx += k - 1
    if idx >= len(q):
        idx %= len(q)
    result.append(q.pop(idx))

print(str(result).replace('[', '<').replace(']', '>'))
