from collections import deque

directions = [(1, 0), (0, 1), (-1, 0), (0, -1)]


def solution(board):
    width = len(board[0])
    height = len(board)
    queue = deque()
    check = [[False for _ in range(width)] for _ in range(height)]


    # 시작점 찾고, 큐에 담고, 방문처리
    loop_break = False
    for r in range(height):
        for c in range(width):
            if board[r][c] == 'R':
                queue.append((r,c))
                check[r][c] = True
                loop_break = True
                break
        if loop_break:
            break

    cost = -1
    while queue:
        cost += 1
        for _ in range(len(queue)):
            r, c = queue.popleft()

            for dr, dc in directions:
                nr, nc = r, c
                nnr, nnc = nr + dr, nc + dc

                # 직선으로 쭉 이동하며 최종적으로 도달 가능한 nr, nc까지 이동
                while 0 <= nnr < height and 0 <= nnc < width and board[nnr][nnc] != 'D':
                    nr, nc = nnr, nnc
                    nnr, nnc = nr + dr, nc + dc

                # (nr, nc)가 방문되어있는 지 확인
                if not check[nr][nc]:
                    if board[nr][nc] == 'G':
                        return cost + 1

                    # 방문 처리 후 큐에 삽입
                    check[nr][nc] = True
                    queue.append((nr, nc))
    return -1
