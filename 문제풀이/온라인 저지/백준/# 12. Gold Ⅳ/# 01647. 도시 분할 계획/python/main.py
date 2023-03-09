import sys

src = sys.stdin
n, m = map(int, src.readline().split())

parents = [k for k in range(n + 1)]
graph = sorted([tuple(map(int, line.split())) for line in src.read().splitlines()], key=lambda x: x[2])


def union(a, b):
    a, b = find(a), find(b)
    if a < b:
        parents[b] = a
    else:
        parents[a] = b


def find(x):
    if parents[x] == x:
        return x
    parents[x] = find(parents[x])
    return parents[x]


total = 0
max = 0
for a, b, c in graph:
    if find(a) != find(b):
        union(a, b)
        total += c
        if c > max:
            max = c

print(total - max)
