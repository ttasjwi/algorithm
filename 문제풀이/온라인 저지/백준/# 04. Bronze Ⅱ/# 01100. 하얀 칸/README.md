# 문제
- 플랫폼 : 백준
- 번호 : 01100
- 제목 : 하얀 칸
- 난이도 : Bronze 2
- 하얀 칸 위에 말이 몇 개 있는지 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1100" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
import sys

board = [list(line.rstrip()) for line in sys.stdin.read().splitlines()]
cnt = 0

for i in range(8):
    for j in range(8):
        if ((i % 2 == 0 and j % 2 == 0) or (i % 2 != 0 and j % 2 != 0)) and board[i][j] == 'F':
            cnt += 1
print(cnt)
```
- 짝수행 짝수열 또는 홀수행 홀수열에 위치한 'F'만 카운팅한다.

---
