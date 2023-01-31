# 문제
- 플랫폼 : 백준
- 번호 : 01260
- 제목 : DFS와 BFS
- 난이도 : Silver 2
- 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1260" target="_blank">링크</a>

---

# 필요 알고리즘
- DFS(깊이 우선 탐색)
- BFS(너비 우선 탐색)

---

# 풀이

## 전체 흐름
```python
input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
print = sys.stdout.write

n, m, v = map(int, input().decode().split())
graph = [[] for _ in range(n + 1)]
for _ in range(m):
    s, e = map(int, input().decode().split())
    graph[s].append(e)
    graph[e].append(s)
graph = [sorted(i) if i else i for i in graph]
answer = '\n'.join((dfs(v, graph, [False] * (n + 1)), bfs(v, graph, [False] * (n + 1))))
print(answer)
```
- 입력을 받고, 인접한 노드를 기록하는 graph를 초기화한다.
  - 양방향이므로 쌍으로 삽입해야한다.
- 접근을 작은 것부터 순서대로 해야하므로, 정렬한다.
- dfs, bfs 결과를 누적하고 출력한다.

## DFS
```python
def dfs(v, graph, check):
    stack = [v]
    result = []
    while stack:
        v = stack.pop()
        if not check[v]:
            check[v] = True
            result.append(str(v))
            for nv in graph[v][::-1]:
                if not check[nv]:
                    stack.append(nv)

    return ' '.join(result)
```
- stack을 활용한다.
- stack을 통해 반복하면, 메서드 호출과 달리 큰것부터 꺼내게 되므로, graph에 접근할 때 역으로 접근한다.
- 스택에서 요소를 꺼내서, 체크되지 않았다면 다음을 수행한다.
  - 체크한다.
  - 결과에 현재 요소를 누적
  - 인접한 방문하지 않은 요소들을 스택에 넣는다.

## BFS
```python
def bfs(v, graph, check):
    check[v] = True
    result = [str(v)]

    queue = [v]
    while queue:
        v = queue.pop(0)
        for nv in graph[v]:
            if not check[nv]:
                check[nv] = True
                result.append(str(nv))
                queue.append(nv)

    return ' '.join(result)
```
- 첫 요소를 방문처리, 결과에도 추가
- 큐에 첫 요소를 삽입
- 큐가 빌 때까지 반복
  - 인접한 요소를 순서대로 탐색하면서, 체크되지 않은 지점을 방문처리, 결과에 추가
  - 큐에 삽입

---
