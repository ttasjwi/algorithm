import io, os, sys

lines = io.BytesIO(os.read(0, os.fstat(0).st_size)).read().splitlines()
print = sys.stdout.write

a = set(n for n in lines[1].split())
print(' '.join('1' if x in a else '0' for x in lines[3].split()))
