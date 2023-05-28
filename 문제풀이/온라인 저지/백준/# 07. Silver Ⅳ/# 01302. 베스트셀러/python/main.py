import sys
from collections import Counter

src = sys.stdin
_ = src.readline()
c = Counter(src.read().splitlines())
print(min(c.keys(), key=lambda k: (-c[k], k)))
