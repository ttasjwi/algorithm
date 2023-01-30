import io, os, sys

print = sys.stdout.write

counts = [0] * 11
counts[1] = 1
counts[2] = 2
counts[3] = 4
for i in range(4, 11):
    counts[i] = sum(counts[i-3:i])

_, *numbers = map(int, io.BytesIO(os.read(0, os.fstat(0).st_size)).read().decode().rstrip().split(sep='\n'))

answer = '\n'.join(str(counts[n]) for n in numbers)
print(answer)
