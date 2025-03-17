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
