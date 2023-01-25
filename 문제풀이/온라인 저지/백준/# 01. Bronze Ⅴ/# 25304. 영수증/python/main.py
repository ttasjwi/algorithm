import io, os, sys

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
print = sys.stdout.write

x = int(input())
n = int(input())

total = 0
for i in range(n):
    price, count = map(int, input().split())
    total += price * count

answer = 'Yes' if x == total else 'No'
print(answer)
