import sys

input = sys.stdin.readline
cur = 0
answer = -1
for i in range(10):
    a, b = map(int, input().split())
    cur = cur - a + b
    if answer < cur:
        answer = cur
print(answer, end = '')
