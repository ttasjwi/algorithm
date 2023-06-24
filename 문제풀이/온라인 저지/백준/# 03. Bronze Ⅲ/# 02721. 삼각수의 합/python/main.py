import sys

input = sys.stdin.readline
print = sys.stdout.write
t = int(input())

dp_f = [0] * 302
dp_g = [0] * 302


def f(k):
    if dp_f[k] > 0:
        return dp_f[k]
    dp_f[k] = k * (k + 1) // 2
    return dp_f[k]


def g(k):
    if dp_g[k] > 0:
        return dp_g[k]
    dp_g[k] = k * f(k + 1)
    return dp_g[k]


for _ in range(t):
    print(str(sum([g(x) for x in range(1, int(input()) + 1)])))
    print('\n')
