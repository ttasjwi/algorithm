import io, os, sys


def dfs(v, graph, check):
    stack = [v]
    result = []
    while stack:
        v = stack.pop()
        if not check[v]:
            check[v] = True
            result.append(str(v))
            for nv in graph[v][::-1]:
                if not check[nv]:
                    stack.append(nv)

    return ' '.join(result)


def bfs(v, graph, check):
    check[v] = True
    result = [str(v)]

    queue = [v]
    while queue:
        v = queue.pop(0)
        for nv in graph[v]:
            if not check[nv]:
                check[nv] = True
                result.append(str(nv))
                queue.append(nv)

    return ' '.join(result)


input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
print = sys.stdout.write

n, m, v = map(int, input().decode().split())
graph = [[] for _ in range(n + 1)]
for _ in range(m):
    s, e = map(int, input().decode().split())
    graph[s].append(e)
    graph[e].append(s)
graph = [sorted(i) if i else i for i in graph]
answer = '\n'.join((dfs(v, graph, [False] * (n + 1)), bfs(v, graph, [False] * (n + 1))))
print(answer)
