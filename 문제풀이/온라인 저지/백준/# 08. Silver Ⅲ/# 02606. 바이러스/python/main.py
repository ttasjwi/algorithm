import sys

input = sys.stdin.readline

n = int(input())
m = int(input())
edges = [[] for _ in range(n+1)]
check = [False] * (n+1)
for i in range(m):
    a, b= map(int, input().split())
    edges[a].append(b)
    edges[b].append(a)

stack = [1]
answer = 0
check[1] = True
while stack:
    node = stack.pop()
    for near_node in edges[node]:
        if not check[near_node]:
            check[near_node] = True
            answer += 1
            stack.append(near_node)
print(answer)
