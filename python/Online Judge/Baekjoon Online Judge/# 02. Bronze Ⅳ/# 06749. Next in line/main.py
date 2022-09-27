import sys

input = lambda: sys.stdin.readline().rstrip()
y = int(input())
m = int(input())
answer = 2 * m - y
print(answer, end='')
