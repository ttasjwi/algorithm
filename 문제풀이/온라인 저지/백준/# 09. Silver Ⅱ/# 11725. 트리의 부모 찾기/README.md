# 문제
- 플랫폼 : 백준
- 번호 : 11725
- 제목 : 트리의 부모 찾기
- 난이도 : Silver 2
- 문제 : <a href="https://www.acmicpc.net/problem/11725" target="_blank">링크</a>

---

# 필요 지식
- 트리
- DFS

---

# 풀이
```python
import io, os, sys

print = sys.stdout.write
lines = io.BytesIO(os.read(0, os.fstat(0).st_size)).read().decode().rstrip().split(sep='\n')

n = int(lines[0])
edges = [[] for _ in range(n+1)] # 인접한 노드들을 모아둔 배열
parents = [0] * (n+1) # 부모 (0이면 초기화 안 된 상태)

for i in range(1, n):
    a, b = map(int, lines[i].split())
    edges[a].append(b)
    edges[b].append(a)

stack = [1]

while stack:
    node = stack.pop()
    for near_node in edges[node]:
        if parents[near_node] == 0:
            parents[near_node] = node
            stack.append(near_node)

print('\n'.join(map(str, parents[2:])))
```
- 배열로 스택을 구현했다.
- 1번 노드를 시작으로 하여 DFS를 수행하였고, 방문할 때마다 직속 부모를 배열에 기록한다.
- 이 때 부모가 존재하면 방문처리로 간주하기 때문에 한 번 방문한 노드에 다시 방문하지 않게 된다.
- 모든 간선의 갯수가 N-1개 이므로 시간 복잡도는 O(N)이 된다

---
