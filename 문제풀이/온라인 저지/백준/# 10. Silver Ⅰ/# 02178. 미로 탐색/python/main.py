import io, os, sys

directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]

input = sys.stdin.readline
print = sys.stdout.write


def bfs():
    queue = [(0, 0)]
    board[0][0] = 0
    level = 0

    while queue:
        size = len(queue)
        level += 1
        for _ in range(size):
            current = queue.pop(0)
            r, c = current[0], current[1]
            for direction in directions:
                nr, nc = r + direction[0], c + direction[1]
                if 0 <= nr < len(board) and 0 <= nc < len(board[0]) and board[nr][nc] == '1':
                    if nr == n - 1 and nc == m - 1:
                        return str(level + 1)
                    board[nr][nc] = '0'
                    queue.append((nr, nc))


n, m = map(int, input().split())
board = [list(input().rstrip()) for _ in range(n)]
print(bfs())
