# 문제
- 플랫폼 : 백준
- 번호 : 02741
- 제목 : N 찍기
- 난이도 : Bronze 5
- N이 주어졌을 때, 1부터 N까지 한 줄에 하나씩 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2741" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
import sys

print = sys.stdout.write

n = int(input())
answer = '\n'.join(str(i) for i in range(1, n+1))
print(answer)
```

---
