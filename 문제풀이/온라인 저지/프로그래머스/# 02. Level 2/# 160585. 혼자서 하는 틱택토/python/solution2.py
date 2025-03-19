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
