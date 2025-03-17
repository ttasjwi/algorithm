# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012952
- 제목 : N-Queen
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12952" target="_blank">링크</a>

---

# 필요 지식
- 백 트래킹

---

# 풀이

### 풀이1: 내 풀이
```python
def solution(n):
    answer = 0

    def backtracking(r, check):
        nonlocal answer
        if r == n:
            # 끝까지 왔다면 answer 증가
            answer += 1
            return
        for c in range(n):
            # 위, 왼쪽 위, 오른쪽 위에 퀸이 있는 지 확인
            if not find(r, c, check):
                # 퀸이 없으면 퀸을 놓고 다음 행 탐색
                check[r][c] = True
                backtracking(r + 1, check)
                check[r][c] = False
        return

    def find(r, c, check):
        # 위
        for nr in range(0, r):
            if check[nr][c]:
                return True
        # 왼쪽 위
        for nr, nc in zip(range(r - 1, -1, -1), range(c - 1, -1, -1)):
            if check[nr][nc]:
                return True
        # 오른쪽 위
        for nr, nc in zip(range(r - 1, -1, -1), range(c + 1, n)):
            if check[nr][nc]:
                return True
        return False

    backtracking(0, [[False for i in range(n)] for i in range(n)])
    return answer
```
- 이차원 배열 형태로, Queen 이 놓인 위치를 True 로 마킹해서 관리

### 풀이2 : 다른 분들 풀이
```python
def solution(n):
    answer = 0

    # r: 현재 행
    # queens : 각 행별로, Queen 이 놓인 열
    def backtracking(r, queens):
        nonlocal answer
        if r == n:
            # 끝까지 왔다면 answer 증가
            answer += 1
            return
        for c in range(n):
            # 위, 왼쪽 위, 오른쪽 위에 퀸이 있는 지 확인
            if not find(r, c, queens):
                # 퀸이 없으면 퀸을 놓고 다음 행 탐색
                queens[r] = c
                backtracking(r + 1, queens)
        return

    def find(r, c, queens):
        for nr in range(0, r):
            # 같은 열에 위치해있거나, 대각선에 위치해있는 경우
            if queens[nr] == c or abs(c-queens[nr]) == r-nr:
                return True
        return False

    backtracking(0, [-1 for _ in range(n)])
    return answer
```
- 각 행별로 Queen 이 위치한 열만 관리하면 충분하므로 공간을 아낄 수 있다

---
