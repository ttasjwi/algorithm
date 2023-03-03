import sys

src = sys.stdin
print = sys.stdout.write

src.readline()
print('\n'.join(line.lower() for line in src.read().splitlines()))
