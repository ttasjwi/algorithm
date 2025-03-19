# 문제
- 플랫폼 : 프로그래머스
- 번호 : 160585
- 제목 : 혼자서 하는 틱택토
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/160585" target="_blank">링크</a>

---

# 필요 지식
- 구현
- DFS

---

# 풀이

## 풀이1: DFS 로 모든 가능성을 구해두기(내 풀이)
```python
# 아이디어 : 실제로 처음 턴부터, 모든 가능한 경우의 틱택토 히스토리를 set 에 담아두기
# board 가 set 에 있으면 true, 없으면 false
def solution(board):
    s = set()
    my_board = [['.' for _ in range(3)] for _ in range(3)]

    def is_victory(turn):
        if turn % 2 == 0:
            symbol = 'X'
        else:
            symbol = 'O'

        for i in range(3):
            if my_board[0][i] == symbol and my_board[1][i] == symbol and my_board[2][i] == symbol:
                return True
            if my_board[i][0] == symbol and my_board[i][1] == symbol and my_board[i][2] == symbol:
                return True
        if my_board[0][0] == symbol and my_board[1][1] == symbol and my_board[2][2] == symbol:
            return True
        if my_board[0][2] == symbol and my_board[1][1] == symbol and my_board[2][0] == symbol:
            return True
        return False

    def dfs(turn):
        # 끝까지 도달했으면 종료
        if turn == 9:
            return

        # 승리조건을 만족하면 종료
        if is_victory(turn):
            return

        # 그리기 : turn 이 짝수이면 'O', turn 이 홀수이면 'X'
        for r in range(3):
            for c in range(3):
                if my_board[r][c] != '.':
                    continue
                if turn % 2 == 0:
                    my_board[r][c] = 'O'
                else:
                    my_board[r][c] = 'X'

                # 현재 상태를 s 에 저장
                s.add(''.join([''.join(line) for line in my_board]))
                dfs(turn + 1)
                my_board[r][c] = '.'

    s.add(''.join([''.join(line) for line in my_board]))
    dfs(0)

    return 1 if ''.join(board) in s else 0
```

## 풀이2: 갯수로 따지기
```python
def solution(board):
    o_count = sum([board[r].count('O') for r in range(3)])
    x_count = sum([board[r].count('X') for r in range(3)])

    # 'O' 의 갯수는 'X' 의 갯수와 같거나 많아야 한다. 
    # 또, 이 둘의 갯수 차이는 1개를 넘을 수 없다.
    if o_count < x_count or o_count - x_count > 1:
        return 0

    # O 가 이겼으나 X 의 갯수가 O보다 1개 많지 않은 경우 잘 못 됐다.
    if is_victory(board, 'O') and x_count + 1 != o_count:
        return 0

    # X 가 이겼으나 둘의 갯수가 같지 않은 경우 잘 못 됐다.
    if is_victory(board, 'X') and x_count != o_count:
        return 0
    return 1


def is_victory(board, player):
    for i in range(3):
        if board[0][i] == player and board[1][i] == player and board[2][i] == player:
            return True
        if board[i][0] == player and board[i][1] == player and board[i][2] == player:
            return True
    if board[0][0] == player and board[1][1] == player and board[2][2] == player:
        return True
    if board[0][2] == player and board[1][1] == player and board[2][0] == player:
        return True
    return False
```
