# 문제
- 플랫폼 : 백준
- 번호 : 01389
- 제목 : 케빈 베이컨의 6단계 법칙
- 난이도 : Silver 1
- 유저 중에서 케빈 베이컨의 수가 가장 작은 사람을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1389" target="_blank">링크</a>

---

# 필요 알고리즘
- DFS/BFS
- 플로이드 워셜

---

# 풀이

## 풀이1 
```python
import sys

input = sys.stdin.readline

inf = 101
n, m = map(int, input().split())
dis = [[0 if i == j else inf for j in range(n + 1)] for i in range(n + 1)]

for _ in range(m):
    a, b = map(int, input().split())
    dis[a][b] = 1
    dis[b][a] = 1

for m in range(1, n + 1):
    for s in range(1, n + 1):
        if s == m or dis[s][m] == inf:
            continue
        for e in range(1, n + 1):
            if s == e or m == e or dis[m][e] == inf:
                continue
            alt = dis[s][m] + dis[m][e]
            if dis[s][e] > alt:
                dis[s][e] = alt
min_sum = 20000
answer = -1
for i in range(1, n + 1):
    total = sum(dis[i][1:])
    if total < min_sum:
        min_sum = total
        answer = i
print(answer)
```
- 플로이드-워셜 알고리즘을 통해 모든 지점에서 출발한 최단거리를 계산

## 풀이2
```python
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
```
- 각 정점마다 BFS를 통해 연결된 정점을 깊이순으로 방문한다.
- 깊이순으로 방문할 때 그 지점이 각각의 최단거리이다.

---
