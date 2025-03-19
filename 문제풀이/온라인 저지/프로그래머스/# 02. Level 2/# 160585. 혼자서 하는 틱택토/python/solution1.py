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
