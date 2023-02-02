from math import sqrt


def solution(number, limit, power):
    attacks = [0] * (number + 1)
    for i in range(1, number + 1):
        for j in range(1, int(sqrt(i)) + 1):
            if i % j == 0:
                attacks[i] += 2 if i // j != j else 1
    return sum(power if attack > limit else attack for attack in attacks[1:])
