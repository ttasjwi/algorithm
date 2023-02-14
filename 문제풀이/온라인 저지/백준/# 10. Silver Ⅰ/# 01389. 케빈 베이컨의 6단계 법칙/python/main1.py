import sys

input = sys.stdin.readline

inf = 101
n, m = map(int, input().split())
dis = [[0 if i == j else inf for j in range(n + 1)] for i in range(n + 1)]

for _ in range(m):
    a, b = map(int, input().split())
    dis[a][b] = 1
    dis[b][a] = 1

for m in range(1, n + 1):
    for s in range(1, n + 1):
        if s == m or dis[s][m] == inf:
            continue
        for e in range(1, n + 1):
            if s == e or m == e or dis[m][e] == inf:
                continue
            alt = dis[s][m] + dis[m][e]
            if dis[s][e] > alt:
                dis[s][e] = alt
min_sum = 20000
answer = -1
for i in range(1, n + 1):
    total = sum(dis[i][1:])
    if total < min_sum:
        min_sum = total
        answer = i
print(answer)
