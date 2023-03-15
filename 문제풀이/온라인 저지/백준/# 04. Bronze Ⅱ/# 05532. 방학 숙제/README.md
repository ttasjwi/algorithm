# 문제
- 플랫폼 : 백준
- 번호 : 05532
- 제목 : 방학 숙제
- 난이도 : Bronze 4
- 겨울 방학동안 숙제를 하지 않고 놀 수 있는 최대 날의 수 계산
- 문제 : <a href="https://www.acmicpc.net/problem/5532" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
import sys

l, a, b, c, d = map(int, sys.stdin.buffer.read().splitlines())
x = a // c + 1 if a % c else a // c
y = b // d + 1 if b % d else b // d
print(l - max(x, y))
```
- 국어를 푸는 일 수, 수학을 푸는 일 수 중 더 큰 값을 전체 일 수에서 빼서 반환하면 된다.

---
