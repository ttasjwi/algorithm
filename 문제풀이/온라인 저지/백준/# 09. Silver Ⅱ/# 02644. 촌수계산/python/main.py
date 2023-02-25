import sys

input = sys.stdin.buffer.readline

n = int(input())
a, b = map(int, input().split())
m = int(input())
check = [False] * (n + 1)
graph = [[] for _ in range(n + 1)]

for _ in range(m):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)


def bfs():
    q = [a]
    depth = -1
    check[a] = True

    while q:
        depth += 1
        for _ in range(len(q)):
            k = q.pop(0)
            for i in graph[k]:
                if i == b:
                    return str(depth + 1)
                if not check[i]:
                    check[i] = True
                    q.append(i)

    return '-1'


print(bfs())
