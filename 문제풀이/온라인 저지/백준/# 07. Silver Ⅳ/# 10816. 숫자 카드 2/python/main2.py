import io, os, sys
from collections import Counter
from operator import itemgetter

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
print = sys.stdout.write

input()
c = Counter(input().decode().split())
input()
answer = ' '.join(map(str, itemgetter(*input().decode().split())(c)))
print(answer)
