import sys
from collections import deque

print = sys.stdout.write
n, k = map(int, input().split())

q = deque()
for i in range(1, n+1):
    q.append(i)
answer = []
print('<')
while q:
    for _ in range(k-1):
        q.append(q.popleft())
    answer.append(str(q.popleft()))
print(', '.join(answer))
print('>')
