from math import sqrt

# 에라토스테네스의 체 : Sieve of Eratosthenes
def sieve(n):
    composite_number = [False, True] + [False] * (n - 1)

    for i in range(2, int(sqrt(n)) + 1):
        if not composite_number[i]:
            for j in range(2 * i, n + 1, i):
                composite_number[j] = True
    return composite_number
