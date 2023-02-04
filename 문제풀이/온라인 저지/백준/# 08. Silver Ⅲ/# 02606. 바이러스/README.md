# 문제
![virus.png](imgs/virus.png)

- 플랫폼 : 백준
- 번호 : 02606
- 제목 : 바이러스
- 난이도 : Silver 3
- 컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를
출력하는 프로그램을 작성
- 문제 : <a href="https://www.acmicpc.net/problem/2606" target="_blank">링크</a>

---

# 필요 알고리즘
- DFS
- BFS
---

# 풀이

## 풀이1 : DFS
```python
import sys

print = sys.stdout.write
input = sys.stdin.readline

n = int(input())

graph = {i: [] for i in range(1, n + 1)}
check = [False] * (n + 1)

for _ in range(int(input())):
    s, e = map(int, input().split())
    graph[s].append(e)
    graph[e].append(s)

stack = [1]
check[1] = True
cnt = 0
while stack:
    current = stack.pop()
    for i in graph[current]:
        if not check[i]:
            check[i] = True
            cnt += 1
            stack.append(i)

print(str(cnt))
```
- 깊이 우선 탐색(DFS)을 사용한다.
- Stack을 활용하거나, 재귀함수를 사용하면 되는데 여기서는 리스트를 통해 Stack을 사용했다.
- 첫번째 정점을 스택에 삽입한다.
- 스택이 빌 때까지 정점을 꺼내, 정점에서 연결된 간선을 통해 인접한 정점을 방문처리하고 카운팅한다.
- 스택이 비었으면 연결된 모든 정점들이 카운팅됐다는 것이다. 결과를 출력한다.

## 풀이2: BFS
```python
import sys

print = sys.stdout.write
input = sys.stdin.readline

n = int(input())

graph = {i: [] for i in range(1, n + 1)}
check = [False] * (n + 1)

for _ in range(int(input())):
    s, e = map(int, input().split())
    graph[s].append(e)
    graph[e].append(s)

q = [1]
check[1] = True
cnt = 0
while q:
    current = q.pop(0)
    for i in graph[current]:
        if not check[i]:
            check[i] = True
            cnt += 1
            q.append(i)
print(str(cnt))
```
- 너비 우선 탐색(BFS)을 통해 카운팅하는 방식이다.
- 여기서는 리스트를 통해 큐를 사용했다.
- 큐가 빌 때까지 큐에서 정점을 꺼내, 인접한 지점을 방문 처리 후, 카운팅 한뒤 큐에 append한다.
- 큐가 비면 모든 연결 정점들이 카운팅됐다는 것이므로 결과를 출력한다.

---
