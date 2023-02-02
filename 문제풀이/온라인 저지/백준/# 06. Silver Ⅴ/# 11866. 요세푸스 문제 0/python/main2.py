import sys

print = sys.stdout.write

n, k = map(int, input().split())
q = [i for i in range(1, n+1)]
result = []
while q:
    for i in range(k-1):
        q.append(q.pop(0))
    result.append(q.pop(0))

print(str(result).replace('[', '<').replace(']', '>'))
