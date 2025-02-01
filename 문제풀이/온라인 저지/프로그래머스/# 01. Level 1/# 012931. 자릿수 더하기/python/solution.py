def solution(n):
    sum = 0
    while n:
        n, r = divmod(n, 10)
        sum += r
    return sum
