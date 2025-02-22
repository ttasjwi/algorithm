def solution(land):
    dp = [[0 for _ in range(4)] for _ in range(len(land))]
    first_score, first_col = 0, -1
    second_score, second_col = 0, -1

    for r in range(len(land)):
        prev_first_score, prev_first_col = first_score, first_col
        prev_second_score, prev_second_col = second_score, second_col

        for c in range(4):
            dp[r][c] = prev_second_score + land[r][c] if c == prev_first_col else prev_first_score + land[r][c]
            if dp[r][c] >= first_score:
                second_score, second_col = first_score, first_col
                first_score, first_col = dp[r][c], c
            elif dp[r][c] >= second_score:
                second_score, second_col = dp[r][c], c
    return first_score
