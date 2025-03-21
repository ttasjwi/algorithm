# 문제
- 플랫폼 : 백준
- 번호 : 21918
- 제목 : 전구
- 난이도 : Bronze 2
- 문제 : <a href="https://www.acmicpc.net/problem/21918" target="_blank">링크</a>

---

# 필요 지식
- 구현

---

# 풀이
```python
import sys

input = sys.stdin.readline
print = sys.stdout.write

n, m = map(int, input().split())
bools = list(map(int, input().split()))
for line in range(m):
    a, b, c = map(int, input().split())
    if a == 1:
        bools[b - 1] = c
    elif a == 2:
        bools[b - 1:c] = [1 - x for x in bools[b - 1:c]]
    elif a == 3:
        bools[b - 1:c] = [0] * (c - b + 1)
    else:
        bools[b - 1:c] = [1] * (c - b + 1)
print(' '.join(list(map(str, bools))))
```
