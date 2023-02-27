import sys

src = sys.stdin
print = sys.stdout.write

n = int(src.readline())
con = [list(map(int, line.split())) for line in src.read().splitlines()]
graph = [[] for _ in range(n)]

for i in range(n):
    for j in range(n):
        if con[i][j]:
            graph[i].append(j)

s = []
answer = []
for i in range(n):
    check = ['0'] * n
    s.append(i)
    while s:
        j = s.pop()
        for k in graph[j]:
            if check[k] == '0':
                check[k] = '1'
                s.append(k)
    answer.append(' '.join(check))
print('\n'.join(answer))
