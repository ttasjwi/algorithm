import sys

print = sys.stdout.write

f, s, g, u, d = map(int, sys.stdin.readline().split())


def bfs():
    if s == g:
        return '0'
    check = [False] * (f + 1)
    check[s] = True
    q = [s]
    dis = -1
    while q:
        dis += 1
        for _ in range(len(q)):
            currentFloor = q.pop(0)
            for x in [u, -d]:
                nextFloor = currentFloor + x

                if nextFloor == g:
                    return str(dis + 1)

                if 1 <= nextFloor <= f and not check[nextFloor]:
                    check[nextFloor] = True
                    q.append(nextFloor)
    return 'use the stairs'


print(bfs())

