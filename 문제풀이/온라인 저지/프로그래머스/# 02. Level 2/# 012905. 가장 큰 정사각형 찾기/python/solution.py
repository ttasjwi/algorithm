def solution(board):
    w = len(board[0])
    h = len(board)

    # 그 지점에 도달할 때까지 가장 긴 정사각형의 길이
    dp = [[0 for _ in range(w + 1)] for _ in range(h + 1)]
    answer = 0
    for r in range(1, h + 1):
        for c in range(1, w + 1):
            # 그 지점에 0 이 있다면 그 지점에 도달한 시점에는 정사각형이 될 수 없다
            if board[r - 1][c - 1] == 0:
                continue

            # 자신의 왼쪽 위, 왼쪽, 위쪽 시점에서의 최대 정사각형 길이들 중 가장 작은 값에 1을 더해야함.
            # 예를 들어 어느 한쪽이 0이면, 그 지점에서 끊겨있을 수 있음.
            # 모든 위치의 정사각형 길이가 같다면 비로소 1 증가하여 확장할 수 있다.
            dp[r][c] = min(dp[r - 1][c], dp[r][c - 1], dp[r - 1][c - 1]) + 1

            if answer < dp[r][c]:
                answer = dp[r][c]
    return answer * answer
