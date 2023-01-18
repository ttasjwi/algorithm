import collections

n = int(input())
q = collections.deque([i for i in range(1, n + 1)])

while len(q) >= 2:
    q.popleft()
    q.append(q.popleft())

print(q.popleft(), end='')
