import sys

input = sys.stdin.readline
print = sys.stdout.write


def dfs(node):
    global answer
    if target in children[node]:
        children[node].remove(target)
    if not children[node]:
        answer += 1
        return
    for child in children[node]:
        dfs(child)


n = int(input())
children = [set() for _ in range(n)]
root = 0
for idx, parent in enumerate(map(int, input().split())):
    if parent == -1:
        root = idx
    else:
        children[parent].add(idx)
target = int(input())
answer = 0
if target != root:
    dfs(root)
print(str(answer))
