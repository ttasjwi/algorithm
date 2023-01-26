import io, os, sys

sys.setrecursionlimit(10 ** 6)
input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
print = sys.stdout.write

DIRECTIONS = [(0, 1), (1, 1), (1, 0), (1, -1), (0, -1), (-1, -1), (-1, 0), (-1, 1)]

w = 0
h = 0
board = []
results = []
count = 0


def main():
    global w, h, board
    while True:
        w, h = map(int, input().decode().split())

        if w == h == 0:
            break

        board = [[int(i) for i in input().decode().split()] for _ in range(0, h)]
        process()

    print('\n'.join(results))


def process():
    global count

    count = 0
    for r in range(0, h):
        for c in range(0, w):
            if board[r][c] == 1:
                count += 1
                board[r][c] = 0
                dfs(r, c)
    results.append(str(count))


def dfs(r: int, c: int):
    for direction in DIRECTIONS:
        nr = r + direction[0]
        nc = c + direction[1]

        if (0 <= nr < h) and (0 <= nc < w) and board[nr][nc] == 1:
            board[nr][nc] = 0
            dfs(nr, nc)


if __name__ == '__main__':
    main()
