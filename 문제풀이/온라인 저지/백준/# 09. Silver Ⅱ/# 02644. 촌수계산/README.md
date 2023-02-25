# 문제
- 플랫폼 : 백준
- 번호 : 02644
- 제목 : 촌수계산
- 난이도 : Silver 2
- 두 사람의 촌수를 나타내는 정수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2644" target="_blank">링크</a>

---

# 필요 알고리즘
- DFS(깊이 우선 탐색)
- BFS(너비 우선 탐색)

---

# 풀이
```python
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
```
- 이 문제는 무방향 그래프에서 두 정점 간의 거리를 계산하는 것과 동일하다.
- 주어진 두 사람 중 어느 한 사람을 시작으로 하여, 그래프 탐색을 통해 다른 찾고자 하는 사람까지의 거리를 계산하면 된다.
- 두 정점 사이의 거리를 계산하는 관점에서는 BFS가 풀이하기 편해서 BFS를 사용해서 풀었다.

---
