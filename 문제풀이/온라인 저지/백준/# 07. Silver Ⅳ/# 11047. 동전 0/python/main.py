import sys

input = sys.stdin.readline
print = sys.stdout.write

n, k = map(int, input().split())
numbers = [int(input()) for _ in range(n)]

count = 0
for i in range(n - 1, -1, -1):
    current, k = divmod(k, numbers[i])
    count += current
    if k == 0:
        break
print(str(count))
