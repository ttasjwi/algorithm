import sys

input = sys.stdin.readline
rows = [input().rstrip() for _ in range(int(input().split()[0]))]
print(sum([len([w for w in row.split(sep='|') if w]) for row in rows])
      + sum([len([w for w in col.split(sep='-') if w]) for col in [''.join(l) for l in map(list, zip(*rows))]]))
