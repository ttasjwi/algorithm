# 문제
- 플랫폼 : 백준
- 번호 : 02578
- 제목 : 빙고
- 난이도 : Silver 4
- 문제 : <a href="https://www.acmicpc.net/problem/2578" target="_blank">링크</a>

---

# 필요 지식
- 구현

---

# 풀이
```python
board = [list(map(int, input().split())) for _ in range(5)]
addresses = [None] * 26


for r in range(5):
    for c in range(5):
        addresses[board[r][c]] = (r,c)

row_checks = [False] * 5
col_checks = [False] * 5
diagonal_check1 = False
diagonal_check2 = False

flag = False
bingo = 0
count = 0

def check_column(c):
    global bingo
    if col_checks[c]:
        return
    for r in range(5):
        if board[r][c] != 0:
            return
    col_checks[c] = True
    bingo += 1
    return

def check_row(r):
    global bingo
    if row_checks[r]:
        return
    for c in range(5):
        if board[r][c] != 0:
            return False
    row_checks[r] = True
    bingo += 1
    return

def check_diagonal1(r, c):
    global bingo, diagonal_check1
    if diagonal_check1:
        return
    if r != c:
        return
    for i in range(5):
        if board[i][i] != 0:
            return
    diagonal_check1 = True
    bingo += 1
    return

def check_diagonal2(r, c):
    global bingo, diagonal_check2
    if diagonal_check2:
        return
    if r + c != 4:
        return
    for i in range(5):
        if board[i][4-i] != 0:
            return
    diagonal_check2 = True
    bingo += 1
    return


for _ in range(5):
    for num in map(int, input().split()):
        count += 1
        r, c = addresses[num]
        board[r][c] = 0

        check_column(c)
        check_row(r)
        check_diagonal1(r,c)
        check_diagonal2(r,c)

        if bingo >= 3:
            flag = True
            break
    if flag:
        break
print(count)
```
- 입력이 들어올 때마다 가로, 세로, 대각선을 한번씩 체크
- 한번 빙고가 확인된 구간은 다시 체크하지 않기 위해  배열로, 체크 상태를 기억한다.
  - 행 체크
  - 열 체크
  - 대각선1 체크(왼쪽) / 대각선2 체크(오른쪽)
- bingo 갯수가 3을 넘어가면, 종료한다.

---
