# 문제
- 플랫폼 : 백준
- 번호 : 01388
- 제목 : 바닥 장식
- 난이도 : Silver 4
- 방 바닥을 장식하는데 필요한 나무 판자의 개수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1388" target="_blank">링크</a>

---

# 필요 알고리즘
- 구현

---

# 풀이

## 풀이1
```python
import sys

input = sys.stdin.readline

n, m = map(int, input().split())
board = [list(input()) for i in range(n)]

count = 0
for r in range(n):
    for c in range(m):
        if board[r][c] == '#':
            continue
        if board[r][c] == '-':
            cur_c = c
            count += 1
            while cur_c < m and board[r][cur_c] == '-':
                board[r][cur_c] = '#'
                cur_c += 1
        if board[r][c] == '|':
            cur_r = r
            count += 1
            while cur_r < n and board[cur_r][c] == '|':
                board[cur_r][c] = '#'
                cur_r += 1

print(count, end='')
```
- 좌상단부터 순서대로 순회하면서, 연속된 '-'을 발견하면 행 방향으로 '#'으로 바꾸고 카운팅,
'-'을 발견하면 열 방향으로 '#'으로 바꾸고 추적하여 카운팅

---

## 풀이2
```python
import sys

input = sys.stdin.readline
rows = [input().rstrip() for _ in range(int(input().split()[0]))]
print(sum([len([w for w in row.split(sep='|') if w]) for row in rows])
      + sum([len([w for w in col.split(sep='-') if w]) for col in [''.join(l) for l in map(list, zip(*rows))]]))
```
- 우선 행단위로 문자열을 읽는다.
- 열의 경우, 각 행 문자열을 join하여, 리스트로 통합시키고 이를 다시 join하여 구한다.
- 행은 '|'으로 split하고, 공백문자를 제외한 나머지 요소의 갯수를 카운팅하여 합산
- 열은 '-'으로 split하고, 공백문자를 제외한 나머지 요소의 갯수를 카운팅하여 합산

---
