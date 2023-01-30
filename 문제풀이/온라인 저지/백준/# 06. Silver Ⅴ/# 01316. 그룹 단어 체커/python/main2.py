import io, os, sys

print = sys.stdout.write

src = io.BytesIO(os.read(0, os.fstat(0).st_size))
lines = src.read().decode().rstrip().split(sep='\n')[1:]

answer = sum(list(line) == sorted(line, key=line.find) for line in lines)
print(str(answer))
