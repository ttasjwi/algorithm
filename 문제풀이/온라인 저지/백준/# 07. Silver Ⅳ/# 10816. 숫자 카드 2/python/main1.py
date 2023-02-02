import io, os, sys
from collections import Counter

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
print = sys.stdout.write

input()
c = Counter(input().decode().split())
input()
answer = ' '.join(str(c[key]) for key in input().decode().split())
print(answer)
