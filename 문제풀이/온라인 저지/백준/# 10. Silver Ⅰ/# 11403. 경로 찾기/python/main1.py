import sys

src = sys.stdin
print = sys.stdout.write

n = int(src.readline())
con = [line.split() for line in src.read().splitlines()]

for m in range(n):
    for s in range(n):
        if con[s][m] == '0':
            continue
        for e in range(n):
            if con[m][e] == '0':
                continue
            con[s][e] = '1'

print('\n'.join(' '.join(line) for line in con))
