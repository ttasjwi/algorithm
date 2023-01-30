import io, os, sys

src = io.BytesIO(os.read(0, os.fstat(0).st_size))

n, *numbers = map(int, src.read().decode().rstrip().split(sep='\n'))
print = sys.stdout.write

scores = [0] * (n+1)

for i in range(1, n+1):
    if i == 1:
        scores[1] = numbers[0]
    elif i == 2:
        scores[2] = numbers[0] + numbers[1]
    else:
        scores[i] = max(scores[i-3] + numbers[i-2], scores[i-2]) + numbers[i-1]

print(str(scores[n]))
