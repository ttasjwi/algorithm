import sys

input = sys.stdin.readline

inf = 10000
n, m = map(int, input().split())
graph = [[] for _ in range(n + 1)]
min_sum = 20000
answer = -1
q = []

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(1, n + 1):
    check = [False] * (n + 1)
    check[i] = True
    q.append(i)
    sum = 0
    depth = -1
    while q:
        depth += 1
        for _ in range(len(q)):
            cur = q.pop(0)
            sum += depth
            for near in graph[cur]:
                if not check[near]:
                    check[near] = True
                    q.append(near)
    if sum < min_sum:
        min_sum = sum
        answer = i
print(answer)
