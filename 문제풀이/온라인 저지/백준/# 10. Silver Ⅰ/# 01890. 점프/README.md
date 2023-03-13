# 문제
- 플랫폼 : 백준
- 번호 : 01890
- 제목 : 점프
- 난이도 : Silver 1
- 가장 왼쪽 위 칸에서 가장 오른쪽 아래 칸으로 문제의 규칙에 맞게 갈 수 있는 경로의 개수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1890" target="_blank">링크</a>

---

# 필요 알고리즘
- DP

---

# 풀이
```python
import sys

# 입력
src = sys.stdin.buffer
n = int(src.readline())
board = [list(map(int, line.split())) for line in src.read().splitlines()]

# dp 배열 초기화 : 해당 지점까지 갈 수 있는 방법의 수
dp = [[0] * n for _ in range(n)]
dp[0][0] = 1

# dp
for i in range(n):
    for j in range(n):
        if board[i][j] == 0:
            continue
        dis = board[i][j]
        if i + dis < n:
            dp[i + dis][j] += dp[i][j]
        if j + dis < n:
            dp[i][j + dis] += dp[i][j]

# 출력
print(dp[n - 1][n - 1])
```
- dp는 해당 위치까지 도달하는 방법의 수이다.
- 0행 0열을 시작위치로 삼는다.
- 각 위치를 방문한다. 이때 해당 위치의 board 배열 값이 0이면 그냥 continue 함.(자기 자신)
- 각 칸에서 오른쪽 아래로 갈 수 있으면 해당 위치의 dp 값에, 현재 값의 dp값을 더한다.
- 최종적으로 마지막 칸의 dp값을 출력하면 된다.

---
