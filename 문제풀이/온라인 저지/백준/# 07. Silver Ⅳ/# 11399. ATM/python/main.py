import sys

input = sys.stdin.buffer.readline

n = int(input())
times = sorted(map(int, input().split()))
sum = times[0]
for i in range(1, n):
    times[i] = times[i-1] + times[i]
    sum += times[i]
print(sum)
