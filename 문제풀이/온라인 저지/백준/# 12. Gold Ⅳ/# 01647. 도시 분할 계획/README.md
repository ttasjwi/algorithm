# 문제
- 플랫폼 : 백준
- 번호 : 01647
- 제목 : 도시 분할 계획
- 난이도 : Gold 4
- 마을을 두개로 분리하고, 각 분리된 마을 안에 집들이 서로 연결되도록 분할할 때 남은 길 유지비의 합의 최솟값을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1647" target="_blank">링크</a>

---

# 필요 지식
- 크루스칼 알고리즘

---

# 풀이
```python
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
```
- 크루스칼 알고리즘을 통해 최소 신장 트리로 만든다.
- 남아있는 간선들 중 가장 비용이 큰 간선을 찾고 그 간선만 제거해주면, 나머지 거리합이 최소가 된다.

---
