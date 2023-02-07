import sys

input = sys.stdin.readline
print = sys.stdout.write


def main():
    m, n, k = map(int, input().split())
    board = [[1] * n for _ in range(m)]
    for _ in range(k):
        x1, y1, x2, y2 = map(int, input().split())
        for y in range(y1, y2):
            for x in range(x1, x2):
                board[y][x] = 0

    directions = [(1, 0), (0, -1), (-1, 0), (0, 1)]

    s = []
    cnt = 0
    areas = []
    for y in range(0, m):
        for x in range(0, n):
            if board[y][x] == 1:
                cnt += 1
                board[y][x] = 0
                s.append((x, y))
                area = 0
                while s:
                    cx, cy = s.pop()
                    area += 1
                    for dx, dy in directions:
                        nx, ny = cx + dx, cy + dy
                        if 0 <= nx < n and 0 <= ny < m and board[ny][nx] == 1:
                            board[ny][nx] = 0
                            s.append((nx, ny))
                areas.append(area)
    print(str(cnt) + '\n')
    print(' '.join(map(str, sorted(areas))))


if __name__ == '__main__':
    main()
