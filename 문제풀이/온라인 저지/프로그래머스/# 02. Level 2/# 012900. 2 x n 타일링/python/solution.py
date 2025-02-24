def solution(n):
    if n == 1:
        return 1
    elif n == 2:
        return 2
    lt, rt = 1, 2
    for _ in range(n-2):
        lt, rt = rt, (lt + rt)%1000000007
    return rt
