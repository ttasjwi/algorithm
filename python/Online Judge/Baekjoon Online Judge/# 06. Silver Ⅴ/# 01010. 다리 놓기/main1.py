import math
import sys

_ = input()

for line in sys.stdin:
    n, m = map(int, line.split())
    comb = math.comb(m, n)
    print(comb)

