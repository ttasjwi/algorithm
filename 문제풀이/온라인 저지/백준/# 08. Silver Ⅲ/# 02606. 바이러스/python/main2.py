import sys

print = sys.stdout.write
input = sys.stdin.readline

n = int(input())

graph = {i: [] for i in range(1, n + 1)}
check = [False] * (n + 1)

for _ in range(int(input())):
    s, e = map(int, input().split())
    graph[s].append(e)
    graph[e].append(s)

q = [1]
check[1] = True
cnt = 0
while q:
    current = q.pop(0)
    for i in graph[current]:
        if not check[i]:
            check[i] = True
            cnt += 1
            q.append(i)
print(str(cnt))
