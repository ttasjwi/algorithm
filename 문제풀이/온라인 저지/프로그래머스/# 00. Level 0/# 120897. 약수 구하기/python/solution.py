from math import sqrt


def solution(n):
    numbers = []

    for i in range(1, int(sqrt(n)) + 1):
        if n % i == 0:
            numbers.append(i)

            if n // i != i:
                numbers.append(n // i)

    return sorted(numbers)


