# 문제
- 플랫폼 : 백준
- 번호 : 13552
- 제목 : 구와 쿼리
- 난이도 : Bronze 1
- 문제 : <a href="https://www.acmicpc.net/problem/13552" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
import sys

input = sys.stdin.readline
print = sys.stdout.write

points = [tuple(map(int, input().split())) for _ in range(int(input()))]
results = []
for _ in range(int(input())):
    x, y, z, r = map(int, input().split())
    rr = r ** 2
    count = 0
    for (a, b, c) in points:
        s = (x - a) ** 2 + (y - b) ** 2 + (z - c) ** 2
        if s <= rr:
            count += 1
    results.append(str(count))
print('\n'.join(results))

```
- 파이썬 기준 통과할 수 없게 만들었다.
- 쓰레기 문제

---
