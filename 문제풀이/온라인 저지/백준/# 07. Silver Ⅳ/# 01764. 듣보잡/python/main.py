import sys

lines = sys.stdin.buffer.read().decode().splitlines()

n, m = map(int, lines[0].split())
c = sorted(set(lines[1:n + 1]) & set(lines[n + 1:]))
print(len(c))
print('\n'.join(c))
