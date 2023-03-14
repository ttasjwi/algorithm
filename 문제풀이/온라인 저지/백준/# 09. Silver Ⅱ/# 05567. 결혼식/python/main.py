import sys

src = sys.stdin.buffer
n = int(src.readline())
m = int(src.readline())
graph = [[] for _ in range(n + 1)]
check = [False] * (n + 1)
for line in src.read().splitlines():
    a, b = map(int, line.split())
    graph[a].append(b)
    graph[b].append(a)


def bfs():
    q = []
    q.append(1)
    check[1] = True
    level = -1
    cnt = 0
    while q:
        level += 1
        if level == 2:
            break
        for _ in range(len(q)):
            x = q.pop(0)
            for friend in graph[x]:
                if not check[friend]:
                    check[friend] = True
                    q.append(friend)
                    cnt += 1
    return cnt


print(bfs())
