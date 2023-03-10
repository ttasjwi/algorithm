import sys
from itertools import permutations

src = sys.stdin
src.readline()
k = int(src.readline())
print(len(set(''.join(c) for c in permutations(src.read().splitlines(), k))))
