def solution(slice, n):
    q, r = divmod(n, slice)
    return q if r == 0 else q + 1
