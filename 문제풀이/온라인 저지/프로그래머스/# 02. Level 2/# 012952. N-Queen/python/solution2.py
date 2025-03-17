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
