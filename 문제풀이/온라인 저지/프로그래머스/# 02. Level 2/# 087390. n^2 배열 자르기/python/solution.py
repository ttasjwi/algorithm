def solution(n, left, right):
    result = []
    for i in range(left, right+1):
        r, c = divmod(i, n)
        result.append(r + 1 if r >= c else c + 1)
    return result
