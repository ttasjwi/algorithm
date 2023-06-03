import math

n, k = map(int, input().split())

aliquots = []

for i in range(1, int(math.sqrt(n)) + 1):
    if n % i == 0:
        aliquots.append(i)
        if i * i != n:
            aliquots.append(n // i)
aliquots.sort()
print(0 if k > len(aliquots) else aliquots[k - 1])
