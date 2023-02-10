import sys

input = sys.stdin.readline
n = int(input())

directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
board = [list(input().rstrip()) for _ in range(n)]
count = 0
nums = []
s = []
for i in range(n):
    for j in range(n):
        if board[i][j] == '1':
            count += 1
            num = 0
            s.append((i, j))
            board[i][j] = '0'
            while s:
                r, c = s.pop()
                num += 1
                for dr, dc in directions:
                    nr, nc = r + dr, c + dc
                    if 0 <= nr < n and 0 <= nc < n and board[nr][nc] == '1':
                        board[nr][nc] = '0'
                        s.append((nr, nc))
            nums.append(num)
print(count)
print('\n'.join(map(str, sorted(nums))))
