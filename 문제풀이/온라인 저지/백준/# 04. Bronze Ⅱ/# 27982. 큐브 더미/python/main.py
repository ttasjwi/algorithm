import sys

input = sys.stdin.readline

n, m = map(int, input().split())
cubes = set()

for i in range(m):
    x, y, z = map(int, input().split())
    cubes.add((x, y, z))

answer = 0

d = [(-1, 0, 0), (1, 0, 0), (0, -1, 0), (0, 1, 0), (0, 0, -1), (0, 0, 1)]

for x, y, z in cubes:
    success = True
    for dx, dy, dz in d:
        if (x + dx, y + dy, z + dz) not in cubes:
            success = False
            break
    if success:
        answer += 1
print(answer)
