# 문제
- 플랫폼 : 백준
- 번호 : 02630
- 제목 : 색종이 만들기
- 난이도 : Silver 2
- 잘라진 햐얀색 색종이, 파란색 색종이의 개수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2630" target="_blank">링크</a>

---

# 필요 알고리즘
- 분할 정복

---

# 풀이
```python
import sys

src = sys.stdin.buffer
n = int(src.readline())
board = [[*map(int, line.split())] for line in src.read().splitlines()]
counts = [0, 0]


def counting(r, c, length):
    start_color = board[r][c]
    for i in range(r, r + length):
        for j in range(c, c + length):
            if board[i][j] != start_color:
                next_length = length // 2
                counting(r, c, next_length)
                counting(r + next_length, c, next_length)
                counting(r, c + next_length, next_length)
                counting(r + next_length, c + next_length, next_length)
                return
    counts[start_color] += 1


counting(0, 0, n)
print('\n'.join(map(str, counts)), end='')
```
- 순서대로 순회하면서 첫번째에 위치한 값과 일치하지 않으면 다시 색종이를 사분할하여 카운팅

---
