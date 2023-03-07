import heapq
import sys

src = sys.stdin
print = sys.stdout.write

n, m, k, x = map(int, src.readline().split())
inf = 1_000_000
graph = [[] for _ in range(n + 1)]
dis = [inf] * (n + 1)
dis[x] = 0

for line in src.read().splitlines():
    a, b = map(int, line.split())
    graph[a].append(b)

q = []
heapq.heappush(q, (0, x))  # 비용, 노드

while q:
    cost, node = heapq.heappop(q)
    if dis[node] < cost:
        continue
    for v in graph[node]:
        alt = cost + 1
        if dis[v] > alt:
            dis[v] = alt
            heapq.heappush(q, (alt, v))

result = [str(i) for i in range(1, n+1) if dis[i] == k]
print('-1' if not result else '\n'.join(result))
