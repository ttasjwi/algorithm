# 문제
- 플랫폼 : 백준
- 번호 : 02606
- 제목 : 바이러스
- 난이도 : Silver 3
- 문제 : <a href="https://www.acmicpc.net/problem/2606" target="_blank">링크</a>

---

# 필요 지식
- DFS
- BFS

---

# 풀이
```python
import sys

input = sys.stdin.readline

n = int(input())
m = int(input())
edges = [[] for _ in range(n+1)]
check = [False] * (n+1)
for i in range(m):
    a, b= map(int, input().split())
    edges[a].append(b)
    edges[b].append(a)

stack = [1]
answer = 0
check[1] = True
while stack:
    node = stack.pop()
    for near_node in edges[node]:
        if not check[near_node]:
            check[near_node] = True
            answer += 1
            stack.append(near_node)
print(answer)
```
