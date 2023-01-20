import sys

t = int(sys.stdin.readline().rstrip())

results = []

for i in range(t):
    a, b = map(int, sys.stdin.readline().rstrip().split())
    sum = a+b
    results.append(sum)

print(*results, sep='\n', end='')
