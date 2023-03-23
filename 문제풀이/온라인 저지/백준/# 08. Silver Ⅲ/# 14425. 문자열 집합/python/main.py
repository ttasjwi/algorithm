import sys

src = sys.stdin

n, m = map(int, src.readline().split())
s = set(src.readline().rstrip() for i in range(n))
print(len([1 for line in src.read().splitlines() if line in s]))
