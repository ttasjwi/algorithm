def solution(n):
    result = []
    while n:
        n, r = divmod(n, 10)
        result.append(r)
    return result
