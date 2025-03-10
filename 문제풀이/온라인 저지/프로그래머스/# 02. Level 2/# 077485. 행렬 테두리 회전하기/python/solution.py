def solution(rows, columns, queries):
    answer = []
    board = [[(r - 1) * columns + c for c in range(1, columns + 1)] for r in range(1, rows + 1)]

    def rotate(board, r1, c1, r2, c2):
        values = [board[r1][c1]]

        # 제일 왼쪽열 위로 밀기
        for r in range(r1 + 1, r2 + 1):
            values.append(board[r][c1])
            board[r - 1][c1] = board[r][c1]

        # 제일 아래 행 왼쪽으로 밀기
        for c in range(c1 + 1, c2 + 1):
            values.append(board[r2][c])
            board[r2][c - 1] = board[r2][c]

        # 제일 오른쪽 열 아래로 밀기
        for r in range(r2 - 1, r1 - 1, -1):
            values.append(board[r][c2])
            board[r + 1][c2] = board[r][c2]

        # 제일 위 열 오른쪽으로 밀기
        for c in range(c2 - 1, c1, -1):
            values.append(board[r1][c])
            board[r1][c + 1] = board[r1][c]

        board[r1][c1+1] = values[0]
        return min(values)

    for x1, y1, x2, y2 in queries:
        answer.append(rotate(board, x1 - 1, y1 - 1, x2 - 1, y2 - 1))
    return answer
