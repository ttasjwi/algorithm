board = [list(map(int, input().split())) for _ in range(5)]
addresses = [None] * 26

for r in range(5):
    for c in range(5):
        addresses[board[r][c]] = (r, c)

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
        if board[i][4 - i] != 0:
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
        check_diagonal1(r, c)
        check_diagonal2(r, c)

        if bingo >= 3:
            flag = True
            break
    if flag:
        break
print(count)
