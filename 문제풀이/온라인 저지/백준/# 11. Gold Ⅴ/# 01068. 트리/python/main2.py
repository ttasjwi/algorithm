import sys

input = sys.stdin.readline
print = sys.stdout.write


def dfs(parents, x):
    parents[x] = -2
    for i in range(len(parents)):
        if x == parents[i]:
            dfs(parents, i)


n = int(input())
parents = list(map(int, input().split()))
remove = int(input())
dfs(parents, remove)

answer = 0
for i in range(len(parents)):
    if parents[i] != -2 and i not in parents:
        answer += 1
print(str(answer))
