import io, os, sys

print = sys.stdout.write
lines = io.BytesIO(os.read(0, os.fstat(0).st_size)).read().decode().rstrip().split(sep='\n')

n = int(lines[0])
edges = [[] for _ in range(n+1)] # 인접한 노드들을 모아둔 배열
parents = [0] * (n+1) # 부모 (0이면 초기화 안 된 상태)

for i in range(1, n):
    a, b = map(int, lines[i].split())
    edges[a].append(b)
    edges[b].append(a)

stack = [1]

while stack:
    node = stack.pop()
    for near_node in edges[node]:
        if parents[near_node] == 0:
            parents[near_node] = node
            stack.append(near_node)

print('\n'.join(map(str, parents[2:])))
