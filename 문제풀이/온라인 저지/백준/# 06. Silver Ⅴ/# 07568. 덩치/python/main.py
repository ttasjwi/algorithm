import sys

src = sys.stdin.buffer
print = sys.stdout.write

n = int(src.readline())
people = [tuple(map(int, line.split())) for line in src.read().splitlines()]
ranks = [1] * n

for i, (x, y) in enumerate(people):
    for j, (ox, oy) in enumerate(people):
        if i == j:
            continue
        if x > ox and y > oy:
            ranks[j] += 1
print(' '.join(map(str, ranks)))
