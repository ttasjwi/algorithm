import io, os, sys

lines = io.BytesIO(os.read(0, os.fstat(0).st_size)).read().decode().rstrip().split(sep='\n')
print = sys.stdout.write

n, m = map(int, lines[0].split())
a = list(map(int, lines[1].split()))
b = list(map(int, lines[2].split()))

p1 = 0
p2 = 0

result = []
while p1 < n and p2 < m:
    if a[p1] <= b[p2]:
        result.append(str(a[p1]))
        p1 += 1
    else:
        result.append(str(b[p2]))
        p2 += 1

while p1 < n:
    result.append(str(a[p1]))
    p1 += 1

while p2 < m:
    result.append(str(b[p2]))
    p2 += 1
print(' '.join(result))
