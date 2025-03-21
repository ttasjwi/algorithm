import sys

input = sys.stdin.readline
print = sys.stdout.write

n, m = map(int, input().split())
bools = list(map(int, input().split()))
for line in range(m):
    a, b, c = map(int, input().split())
    if a == 1:
        bools[b - 1] = c
    elif a == 2:
        bools[b - 1:c] = [1 - x for x in bools[b - 1:c]]
    elif a == 3:
        bools[b - 1:c] = [0] * (c - b + 1)
    else:
        bools[b - 1:c] = [1] * (c - b + 1)
print(' '.join(list(map(str, bools))))
