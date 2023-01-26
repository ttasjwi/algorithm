import io, os, sys

print = sys.stdout.write

lines = io.BytesIO(os.read(0, os.fstat(0).st_size)).readlines()[1:]
lines = ''.join([f'{idx + 1}. {line.decode()}' for idx, line in enumerate(lines)])
print(lines)
