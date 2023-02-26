import sys

print('\n'.join([str(sum(map(int, line.split()))) for line in sys.stdin.buffer.read().splitlines()[:-1]]))
