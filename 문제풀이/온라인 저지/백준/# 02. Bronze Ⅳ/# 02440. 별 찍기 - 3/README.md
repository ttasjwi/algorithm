# 문제
- 플랫폼 : 백준
- 번호 : 02440
- 제목 : 별 찍기 - 3
- 난이도 : Bronze 4
- 첫째 줄에는 별 N개, 둘째 줄에는 별 N-1개, ..., N번째 줄에는 별 1개 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2440" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
import sys

print = sys.stdout.write

n = int(input())
answer = '\n'.join('*' * i for i in range(n, 1 - 1, -1))
print(answer)

```
- n부터 1까지 거꾸로 반복

---
