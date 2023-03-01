import sys

lines = sys.stdin.buffer.read().splitlines()
print = sys.stdout.write

cursor = 1
for _ in range(int(lines[0])):
    n, m = map(int, lines[cursor].split())
    print(str(n - 1))
    print('\n')
    cursor += m + 1
