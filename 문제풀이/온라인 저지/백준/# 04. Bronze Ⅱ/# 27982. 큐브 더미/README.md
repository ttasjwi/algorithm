# 문제
- 플랫폼 : 백준
- 번호 : 27982
- 제목 : 큐브 더미
- 난이도 : Bronze 2
- 문제 : <a href="https://www.acmicpc.net/problem/27982" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
import sys

input = sys.stdin.readline

n, m = map(int, input().split())
cubes = set()

for i in range(m):
    x, y, z = map(int, input().split())
    cubes.add((x, y, z))

answer = 0

d = [(-1, 0, 0), (1, 0, 0), (0, -1, 0), (0, 1, 0), (0, 0, -1), (0, 0, 1)]

for x, y, z in cubes:
    success = True
    for dx, dy, dz in d:
        if (x + dx, y + dy, z + dz) not in cubes:
            success = False
            break
    if success:
        answer += 1
print(answer)
```
- 각 큐브 좌표를 파싱해서, cubes 에 삽입
- cubes 의 각 원소를 순회하면서 (+-1, +-1, +-1) 한 좌표가 cubes 에 있는 지 확인

---
