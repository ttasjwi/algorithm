import sys

for line in sys.stdin:
    n, s = map(int, line.split())
    print(s//(n+1))


