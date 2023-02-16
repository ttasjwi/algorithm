from collections import deque

n, k = map(int, input().split())

funcs = [lambda x: x - 1, lambda x: x + 1, lambda x: 2 * x]


def bfs(n, k):
    if n == k:
        return 0
    q = deque()
    depth = -1
    check = [False] * 100001
    check[n] = True
    q.append(n)
    while q:
        depth += 1
        for _ in range(len(q)):
            x = q.popleft()
            for fun in funcs:
                y = fun(x)
                if 0 <= y <= 100000 and not check[y]:
                    if y == k:
                        return depth + 1
                    check[y] = True
                    q.append(y)


print(bfs(n, k))
