# 문제
- 플랫폼 : 백준
- 번호 : 05014
- 제목 : 스타트링크
- 난이도 : Silver 1
- 강호가 S층에서 G층으로 가기 위해 눌러야 하는 버튼의 수의 최솟값을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/5014" target="_blank">링크</a>

---

# 필요 알고리즘
- BFS

---

# 풀이
```python
import sys

print = sys.stdout.write

f, s, g, u, d = map(int, sys.stdin.readline().split())


def bfs():
    if s == g:
        return '0'
    check = [False] * (f + 1)
    check[s] = True
    q = [s]
    dis = -1
    while q:
        dis += 1
        for _ in range(len(q)):
            currentFloor = q.pop(0)
            for x in [u, -d]:
                nextFloor = currentFloor + x

                if nextFloor == g:
                    return str(dis + 1)

                if 1 <= nextFloor <= f and not check[nextFloor]:
                    check[nextFloor] = True
                    q.append(nextFloor)
    return 'use the stairs'


print(bfs())
```
- bfs를 통해, 이동할 수 있는 층들을 순서대로 탐색해나간다.
- 얼마만큼 눌러야하는 지 단계적으로 따질 수 있다.

---
