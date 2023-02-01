import io, os, sys

print = sys.stdout.write

lines = io.BytesIO(os.read(0, os.fstat(0).st_size)).read().decode().rstrip().split(sep='\n')
lines = open('input.txt', 'rb').read().decode().rstrip().split(sep='\n')
