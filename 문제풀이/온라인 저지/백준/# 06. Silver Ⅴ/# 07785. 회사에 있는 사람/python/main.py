import sys

input = sys.stdin.readline
print = sys.stdout.write

s = set()
for _ in range(int(input())):
    x, y = input().split()
    if y == 'enter':
        s.add(x)
    else:
        s.remove(x)
print('\n'.join(sorted(s, reverse=True)))
