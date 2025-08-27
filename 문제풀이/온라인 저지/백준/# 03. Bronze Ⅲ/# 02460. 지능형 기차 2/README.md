# 문제
- 플랫폼 : 백준
- 번호 : 02460
- 제목 : 지능형 기차 2
- 난이도 : Bronze 3
- 문제 : <a href="https://www.acmicpc.net/problem/2460" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
import sys

input = sys.stdin.readline
cur = 0
answer = -1
for i in range(10):
    a, b = map(int, input().split())
    cur = cur - a + b
    if answer < cur:
        answer = cur
print(answer, end = '')
```
- 최댓값을 기억해두고 매번 비교하면서 갱신

---
