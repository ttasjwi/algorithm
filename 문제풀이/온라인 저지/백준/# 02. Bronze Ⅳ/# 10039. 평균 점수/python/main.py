import sys

print(sum(40 if x < 40 else x for x in list(map(int, sys.stdin.buffer.read().splitlines()))) // 5)
