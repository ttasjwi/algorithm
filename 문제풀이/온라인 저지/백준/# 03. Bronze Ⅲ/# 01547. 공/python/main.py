import sys

src = sys.stdin.buffer

src.readline()
cups = [0, 1, 0, 0]

for line in src.read().splitlines():
    x, y = map(int, line.split())
    cups[x], cups[y] = cups[y], cups[x]
print(cups.index(1))
