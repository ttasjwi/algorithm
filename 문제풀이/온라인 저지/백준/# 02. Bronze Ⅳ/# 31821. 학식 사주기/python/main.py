import sys

input = sys.stdin.readline
print = sys.stdout.write

n = int(input())
prices = list(map(int, [input() for _ in range(n)]))

result = 0
m = int(input())
for i in range(m):
    result += prices[int(input()) - 1]
print(str(result))
