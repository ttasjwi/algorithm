# 문제
- 플랫폼 : 백준
- 번호 : 17837
- 제목 : 새로운 게임 2
- 난이도 : Gold 2
- 문제 : <a href="https://www.acmicpc.net/problem/17837" target="_blank">링크</a>

---

# 필요 지식
- 구현
- 스택

---

# 풀이
```python
import sys

input = sys.stdin.readline
print = sys.stdout.write

directions = [(0, 1), (0, -1), (-1, 0), (1, 0)]

n, k = map(int, input().split())

# 체스판 : 각 칸에는 칸의 색깔, 위치한 말을 순서대로 담는 스택을 둠
board = [list(map(lambda x: [int(x), []], input().split())) for _ in range(n)]

# 말들의 리스트
horses = [list(map(lambda x: int(x) - 1, input().split())) for _ in range(k)]

# 말들을 0,1,2, ... 라 할 때 이들을 체스판 자신의 위치 스택에 삽입
for i in range(k):
    r, c, d = horses[i]
    board[r][c][1].append(i)

turn = 1

while turn <= 1000:
    for horse_index in range(k):
        # 말의 행, 열, 방향
        r, c, d = horses[horse_index]
        
        # 말이 다음에 이동할 위치
        nr, nc = r + directions[d][0], c + directions[d][1]
        
        # 다음 위치가 경계 밖이거나, 파란색일 경우
        if (not 0 <= nr < n) or (not 0 <= nc < n) or board[nr][nc][0] == 2:
            # 방향을 반대로 바꿈
            d = d + 1 if (d % 2 == 0) else d - 1
            horses[horse_index][2] = d
            
            nr, nc = r + directions[d][0], c + directions[d][1]
            
            # 방향을 반대로 바꾸고 다음 위치 역시 경계 밖이거나, 파란색이면 멈추기
            if (not 0 <= nr < n) or (not 0 <= nc < n) or board[nr][nc][0] == 2:
                continue
        
        # 현 위치에서 이동할 말들(말 자신 및, 자신보다 위에 쌓인 말들)
        move_horse_indices = board[r][c][1][board[r][c][1].index(horse_index):]

        # 다음 칸이 빨간색이면 뒤집어서 이동해야함
        if board[nr][nc][0] == 1:
            move_horse_indices.reverse()
            
        # 다음 칸으로 이동할 말들을 전부 복사
        board[nr][nc][1] += move_horse_indices
        
        # 이동할 말들의 현재 행, 열 위치를 갱신하고, 기존칸 스택에서 제거
        for move_horse_index in move_horse_indices:
            horses[move_horse_index][0] = nr
            horses[move_horse_index][1] = nc
            board[r][c][1].pop()
        
        # 이동한 칸의 스택 크기가 4 이상이면 종료
        if len(board[nr][nc][1]) >= 4:
            print(str(turn))
            exit(0)
    turn += 1
print('-1')
```
