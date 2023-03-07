# 문제
- 플랫폼 : 백준
- 번호 : 18352
- 제목 : 특정 거리의 도시
- 난이도 : Silver 2
- 최단 거리가 정확히 K인 모든 도시들의 번호를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/18352" target="_blank">링크</a>

---

# 필요 알고리즘
- 다익스트라 알고리즘

---

# 풀이
```python
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
```
- 시작점을 기준으로 다익스트라 알고리즘을 통해 최단거리를 계산한다.
- 비용이 k인 지점들을 순서대로 출력한다.

---
