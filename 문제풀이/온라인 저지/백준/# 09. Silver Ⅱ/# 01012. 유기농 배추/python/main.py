import sys

input = sys.stdin.readline
print = sys.stdout.write


def main():
    s = []
    answer = []
    direction = [(0, 1), (1, 0), (0, -1), (-1, 0)]
    for _ in range(int(input())):
        m, n, k = map(int, input().split())
        board = [[0] * m for _ in range(n)]
        for _ in range(k):
            x, y = map(int, input().split())
            board[y][x] = 1
        cnt = 0
        for i in range(n):
            for j in range(m):
                if board[i][j]:
                    board[i][j] = 0
                    cnt += 1
                    s.append((i, j))
                    while s:
                        r, c = s.pop()
                        for dr, dc in direction:
                            nr, nc = r + dr, c + dc
                            if (0 <= nr < n) and (0 <= nc < m) and board[nr][nc]:
                                board[nr][nc] = 0
                                s.append((nr, nc))
        answer.append(cnt)
    print('\n'.join(map(str, answer)))


main()
