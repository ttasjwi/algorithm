from collections import deque

s, t = input().split()
costs = [100] * len(s)
q = deque()
for i, ch in enumerate(s):
    if ch == t:
        q.append(i)

cost = -1
while q:
    cost += 1
    size = len(q)
    for _ in range(size):
        i = q.popleft()
        if costs[i] <= cost:
            continue
        costs[i] = cost
        if i-1 >= 0:
            q.append(i-1)
        if i+1 < len(s):
            q.append(i+1)
print(*costs, end='')
