import sys
from itertools import permutations

print = sys.stdout.write
n, m = map(int, input().split())

print('\n'.join(list(map(' '.join, permutations(map(str, range(1, n+1)), m)))))
