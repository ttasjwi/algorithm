import sys

input = lambda: sys.stdin.readline().rstrip()
n, x = map(int, input().split())
result = [k for k in input().split() if int(k) < x]
print(*result, end='')
