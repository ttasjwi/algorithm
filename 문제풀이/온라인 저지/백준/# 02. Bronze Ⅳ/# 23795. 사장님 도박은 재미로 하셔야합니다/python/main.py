import sys

print(sum(map(int, sys.stdin.buffer.read().splitlines()[:-1])))

