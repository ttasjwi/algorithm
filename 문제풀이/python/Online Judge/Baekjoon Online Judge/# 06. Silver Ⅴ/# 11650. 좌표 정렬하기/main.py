import sys

points = sys.stdin.readlines()[1:]
points.sort(key=lambda line: (int(line.split()[0]), int(line.split()[1])))

print(''.join(points), end='')
