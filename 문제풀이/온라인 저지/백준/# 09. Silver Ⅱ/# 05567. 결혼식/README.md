# 문제
- 플랫폼 : 백준
- 번호 : 05567
- 제목 : 결혼식
- 난이도 : Silver 2
- 상근이의 결혼식에 초대하는 동기의 수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/5567" target="_blank">링크</a>

---

# 필요 지식
- BFS

---

# 풀이
```python
import sys

src = sys.stdin.buffer
n = int(src.readline())
m = int(src.readline())
graph = [[] for _ in range(n + 1)]
check = [False] * (n + 1)
for line in src.read().splitlines():
    a, b = map(int, line.split())
    graph[a].append(b)
    graph[b].append(a)


def bfs():
    q = []
    q.append(1)
    check[1] = True
    level = -1
    cnt = 0
    while q:
        level += 1
        if level == 2:
            break
        for _ in range(len(q)):
            x = q.pop(0)
            for friend in graph[x]:
                if not check[friend]:
                    check[friend] = True
                    q.append(friend)
                    cnt += 1
    return cnt


print(bfs())
```
- 상근이의 level을 0이라 하면, 상근이의 친구의 level은 1, 친구의 친구의 level은 2가 된댜.
- level 1, 2의 사람들만 카운팅한다.

---

