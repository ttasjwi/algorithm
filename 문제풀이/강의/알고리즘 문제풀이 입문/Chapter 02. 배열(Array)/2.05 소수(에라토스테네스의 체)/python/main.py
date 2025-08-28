from math import sqrt

n = int(input())
is_prime = [True] * (n + 1)
is_prime[0], is_prime[1] = False, False # 소수가 아니면 False

for i in range(2, int(sqrt(n)) + 1):
    if is_prime[i]:
        for j in range(i * 2, n + 1, i):
            is_prime[j] = False
answer = is_prime.count(True)
print(answer)
