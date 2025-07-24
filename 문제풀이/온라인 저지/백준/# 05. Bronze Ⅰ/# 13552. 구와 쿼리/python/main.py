import sys

input = sys.stdin.readline
print = sys.stdout.write

points = [tuple(map(int, input().split())) for _ in range(int(input()))]
results = []
for _ in range(int(input())):
    x, y, z, r = map(int, input().split())
    rr = r ** 2
    count = 0
    for (a, b, c) in points:
        s = (x - a) ** 2 + (y - b) ** 2 + (z - c) ** 2
        if s <= rr:
            count += 1
    results.append(str(count))
print('\n'.join(results))
