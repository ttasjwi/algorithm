import sys
from collections import deque

input = sys.stdin.buffer.readline

direction = [(1, 0, 0), (-1, 0, 0), (0, 0, 1), (0, 1, 0), (0, 0, -1), (0, -1, 0)]
m = 0
n = 0
h = 0
cnt = 0
box = None
q = None


def main():
    get_args()
    init_queue()
    answer = bfs()
    print(answer)


def get_args():
    global m, n, h, box
    m, n, h = map(int, input().split())
    box = [[[*map(int, input().split())] for _ in range(n)] for _ in range(h)]


def init_queue():
    global q, cnt, z
    q = deque()
    cnt = 0
    for z in range(h):
        for y in range(n):
            for x in range(m):
                if box[z][y][x] == 1:
                    q.append((z, y, x))
                elif box[z][y][x] == 0:
                    cnt += 1


def bfs():
    global cnt
    max_day = -1
    while q:
        max_day += 1
        for _ in range(len(q)):
            z, r, c = q.popleft()
            for dz, dy, dx in direction:
                nz, ny, nx = z + dz, r + dy, c + dx
                if 0 <= nz < h and 0 <= ny < n and 0 <= nx < m and box[nz][ny][nx] == 0:
                    cnt -= 1
                    box[nz][ny][nx] = -1  # 방문 처리
                    q.append((nz, ny, nx))
    return -1 if cnt else max_day


main()
