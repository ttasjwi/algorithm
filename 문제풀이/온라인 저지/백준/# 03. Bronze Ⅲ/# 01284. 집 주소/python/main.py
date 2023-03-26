import sys

print('\n'.join(str(sum(4 if ch == '0' else 2 if ch == '1' else 3 for ch in line) + len(line) + 1) for line in sys.stdin.read().splitlines()[:-1]))
