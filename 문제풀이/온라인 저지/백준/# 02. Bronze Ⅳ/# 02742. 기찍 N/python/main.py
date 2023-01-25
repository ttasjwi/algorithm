import sys

print = sys.stdout.write

n = int(input())
print('\n'.join(str(i) for i in range(n, 0, -1)))
