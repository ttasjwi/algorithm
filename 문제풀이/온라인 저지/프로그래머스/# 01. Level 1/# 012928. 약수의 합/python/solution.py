import math

def solution(n):
    sum = 0
    for i in range(1, int(math.sqrt(n)) + 1):
        q, r = divmod(n, i)
        if r == 0:
            sum += i
            if q != i:
                sum += q
    return sum
