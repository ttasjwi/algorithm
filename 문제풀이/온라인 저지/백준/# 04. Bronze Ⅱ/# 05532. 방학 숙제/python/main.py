import sys

l, a, b, c, d = map(int, sys.stdin.buffer.read().splitlines())
x = a // c + 1 if a % c else a // c
y = b // d + 1 if b % d else b // d
print(l - max(x, y))
