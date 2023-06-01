import sys

src = sys.stdin.buffer
n = int(src.readline())
print(sum([int(line) for line in src.read().splitlines()]) - (n - 1))
