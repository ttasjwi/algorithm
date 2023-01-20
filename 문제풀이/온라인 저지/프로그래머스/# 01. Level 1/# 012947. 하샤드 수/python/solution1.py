def solution(x):
    n = x
    total = 0

    while n > 0:
        total += n%10
        n //= 10

    return x%total == 0

