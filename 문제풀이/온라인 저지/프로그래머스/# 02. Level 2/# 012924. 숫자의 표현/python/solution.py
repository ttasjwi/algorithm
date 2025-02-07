def solution(n):
    lt = 1
    rt = 1
    answer = 0
    while lt <= rt <= n:
        sum = ((lt + rt) * (rt - lt + 1)) >> 1
        if sum < n:
            rt += 1
        elif sum == n:
            answer += 1
            lt += 1
            rt += 1
        else:
            lt += 1
    return answer
