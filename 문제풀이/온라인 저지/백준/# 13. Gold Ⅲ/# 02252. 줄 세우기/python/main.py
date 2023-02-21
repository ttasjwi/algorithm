import sys

src = sys.stdin.buffer
n, _ = map(int, src.readline().split())
graph = [[] for _ in range(n + 1)]
in_degrees = [0] * (n + 1)

for line in src.read().splitlines():
    a, b = map(int, line.split())
    in_degrees[b] += 1
    graph[a].append(b)

s = []
answer = []
for i in range(1, n + 1):
    if not in_degrees[i]:
        s.append(i)
        answer.append(str(i))

while s:
    x = s.pop()
    for y in graph[x]:
        in_degrees[y] -= 1
        if not in_degrees[y]:
            s.append(y)
            answer.append(str(y))
sys.stdout.write(' '.join(answer))
