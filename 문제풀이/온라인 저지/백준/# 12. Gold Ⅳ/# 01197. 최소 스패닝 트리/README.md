# 문제
- 플랫폼 : 백준
- 번호 : 01197
- 제목 : 최소 스패닝 트리
- 난이도 : Gold 4
- 그래프가 주어졌을 때, 그 그래프의 최소 스패닝 트리를 구하고, 최소 스패닝 트리의 가중치를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1197" target="_blank">링크</a>

---

# 필요 지식
- 크루스칼 알고리즘 -> 최소 스패닝 트리(MST)

---

# 풀이
```python
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
```
- find 함수 : 루트 노드를 찾아내고 현재 부모를 루트 노드로 갱신
- union 함수 : 두 노드의 부모를 통일
- 간선들을 비용 순으로 오름차순 정렬한다. 
- 모든 간선을 순회하면서, 사이클이 없을 경우(부모가 서로 다를 경우)에 한하여 union하고 가중치를 더해 나간다.
- cnt를 세고 모든 노드들을 순회할 필요 없이, cnt가 v-1(노드-1)일 때 바로 탈출할 수 있다.

---
