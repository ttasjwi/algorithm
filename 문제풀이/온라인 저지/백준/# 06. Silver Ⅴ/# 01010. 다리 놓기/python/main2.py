import sys
from math import comb

input = sys.stdin.readline
print = sys.stdout.write

answer = []
for _ in range(int(input())):
    n, m = map(int, input().split())
    answer.append(str(comb(m, n)))
print('\n'.join(answer))
