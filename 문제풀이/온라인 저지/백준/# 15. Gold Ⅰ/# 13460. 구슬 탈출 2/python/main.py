import sys
from collections import deque

input = sys.stdin.readline
print = sys.stdout.write
directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]

h, w = map(int, input().split())
board = []

for _ in range(h):
    board.append(list(input().rstrip()))

start_rr = 0
start_rc = 0
start_br = 0
start_bc = 0

# 구슬 위치 초기화
for r in range(h):
    for c in range(w):
        if board[r][c] == 'R':
            start_rr = r
            start_rc = c
        elif board[r][c] == 'B':
            start_br = r
            start_bc = c

# 매순간 빨간 구슬, 파란 구슬의 위치
queue = deque([(start_rr, start_rc, start_br, start_bc)])

# 빨간구슬/파란구슬 방문 배열
check = [[[[False] * w for _ in range(h)] for _ in range(w)] for _ in range(h)]
check[start_rr][start_rc][start_br][start_bc] = True

def move(r, c, dr, dc):
    move_count = 0
    # 다음 위치가 벽이거나, 현 위치가 구멍일 때까지 이동
    while not (board[r+dr][c+dc] == '#' or board[r][c] == 'O'):
        move_count += 1
        r += dr
        c += dc
    return r, c, move_count

def get_cost():
    cost = -1
    while queue:
        cost += 1
        if cost > 10:
            return -1
        for _ in range(len(queue)):
            rr, rc, br, bc = queue.popleft()
            for dr, dc in directions:
                next_rr, next_rc, red_move_count = move(rr, rc, dr, dc)
                next_br, next_bc, blue_move_count = move(br, bc, dr, dc)

                # 파란구슬이 구멍에 빠지면 실패
                if board[next_br][next_bc] == 'O':
                    continue

                # 빨간구슬이 구멍에 빠지면 성공(10회 이내에 들어가야함)
                if board[next_rr][next_rc] == 'O' and cost < 10:
                    return cost + 1

                # 위치가 겹쳤을 경우 많이 이동한 구슬을 한 번 뒤로 이동 시킴
                if next_rr == next_br and next_rc == next_bc:
                    if red_move_count > blue_move_count:
                        next_rr -= dr
                        next_rc -= dc
                    else:
                        next_br -= dr
                        next_bc -= dc
                # 방문 상태 확인 후 방문 처리 및 큐 삽입
                if not check[next_rr][next_rc][next_br][next_bc]:
                    check[next_rr][next_rc][next_br][next_bc] = True
                    queue.append((next_rr, next_rc, next_br, next_bc))
    return -1

print(str(get_cost()))
