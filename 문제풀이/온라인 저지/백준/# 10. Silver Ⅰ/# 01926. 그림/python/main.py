import sys


def main():
    input = sys.stdin.readline
    print = sys.stdout.write
    directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]

    n, m = map(int, input().split())
    board = [[int(ch) for ch in input().split()] for _ in range(n)]
    cnt = 0
    max_area = 0
    s = []
    for i in range(n):
        for j in range(m):
            if board[i][j]:
                board[i][j] = 0
                cnt += 1
                area = 1
                s.append((i, j))
                while s:
                    r, c = s.pop()
                    for dr, dc in directions:
                        nr, nc = r + dr, c + dc
                        if 0 <= nr < n and 0 <= nc < m and board[nr][nc]:
                            board[nr][nc] = 0
                            area += 1
                            s.append((nr, nc))
                if area > max_area:
                    max_area = area
    print('\n'.join((str(cnt), str(max_area))))


main()
