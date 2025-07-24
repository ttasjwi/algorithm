import io, os, sys

# 출력
print = sys.stdout.write

line = sys.stdin.readline

lines = io.BytesIO(os.read(0, os.fstat(0).st_size)).read().decode().rstrip().split(sep='\n')
lines = open('input.txt', 'rb').read().decode().rstrip().split(sep='\n')
