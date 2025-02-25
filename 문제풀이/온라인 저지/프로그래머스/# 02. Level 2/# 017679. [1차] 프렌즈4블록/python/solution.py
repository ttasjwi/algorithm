def solution(m, n, board):
    board = [[board[r][c] for c in range(n)] for r in range(m)]

    answer = 0

    while True:
        # 삭제 목록
        delete_set = set()
        for r in range(m - 1):
            for c in range(n - 1):
                if board[r][c] and all(board[r][c] == board[nr][nc] for nr, nc in [(r+1, c), (r, c+1), (r+1, c+1)]):
                    delete_set |= {(r, c), (r+1, c), (r, c+1), (r+1, c+1)}

        # 제거할 블록이 없으면 종료
        if not delete_set:
            break

        # 블록 제거
        for (r, c) in delete_set:
            board[r][c] = None
            answer += 1

        # 각 열
        for c in range(n):
            empty_row = m - 1 # 최하단 빈칸

            # 아래행부터 위 행으로 탐색
            for r in range(m-1, -1, -1):
                # 현재 행이 비어있지 않으면
                if board[r][c]:
                    # 가장 최하단 빈칸으로 이동
                    board[empty_row][c] = board[r][c]

                    if empty_row != r: # r에 있던 요소가 empty_row 로 이동했는데, 둘이 다르다면 위치가 이동한 것이므로 board[r][c] 를 비움
                        board[r][c] = None
                    empty_row -= 1 # 다음 블록이 내려갈 위치 갱신
    return answer
