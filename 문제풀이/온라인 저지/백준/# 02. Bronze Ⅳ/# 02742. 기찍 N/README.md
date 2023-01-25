# 문제
- 플랫폼 : 백준
- 번호 : 02742
- 제목 : 기찍 N
- 난이도 : Bronze 4
- 자연수 N이 주어졌을 때, N부터 1까지 한 줄에 하나씩 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2742" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
import sys

print = sys.stdout.write

n = int(input())
print('\n'.join(str(i) for i in range(n, 0, -1)))
```

---
