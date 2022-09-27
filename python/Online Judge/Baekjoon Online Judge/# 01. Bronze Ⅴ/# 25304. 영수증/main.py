import sys

x = int(sys.stdin.readline().rstrip())
n = int(sys.stdin.readline().rstrip())

total = 0
for i in range(n):
    a, b = map(int, sys.stdin.readline().rstrip().split())
    total += a * b

print("Yes" if total == x else "No", end='')

