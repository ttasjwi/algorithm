import sys
from itertools import accumulate

lines = map(bytes.split, sys.stdin.buffer.read().splitlines())
n, m = next(lines)
sums = list(accumulate(map(int, next(lines)), initial=0))
sys.stdout.write('\n'.join(str(sums[int(j)] - sums[int(i) - 1]) for i, j in lines))
