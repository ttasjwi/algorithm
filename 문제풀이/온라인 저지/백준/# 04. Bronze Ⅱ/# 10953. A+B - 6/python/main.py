import io, os, sys

lines = io.BytesIO(os.read(0, os.fstat(0).st_size)).readlines()[1:]
print = sys.stdout.write

answer = '\n'.join(str(sum(map(int, line.decode().split(sep=',')))) for line in lines)
print(answer)
