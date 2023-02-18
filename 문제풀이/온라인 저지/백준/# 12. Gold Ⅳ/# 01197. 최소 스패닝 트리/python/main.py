import sys

src = sys.stdin.buffer

v, e = map(int, src.readline().split())
parents = [i for i in range(v + 1)]
graph = sorted([tuple(map(int, line.split())) for line in src.read().splitlines()], key=lambda x: x[2])


def find(x):
    if parents[x] == x:
        return x
    else:
        parents[x] = find(parents[x])
        return parents[x]


def union(a, b):
    a, b = find(a), find(b)
    if a < b:
        parents[b] = a
    elif a > b:
        parents[a] = b


cost = 0
cnt = 0
for a, b, c in graph:
    if find(a) != find(b):
        union(a, b)
        cost += c
        cnt += 1
        if cnt == v - 1:
            break
print(cost)
