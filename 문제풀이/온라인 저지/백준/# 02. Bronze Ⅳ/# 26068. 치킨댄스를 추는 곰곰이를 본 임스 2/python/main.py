import sys

cnt = 0
input = sys.stdin.readline
for _ in range(int(input())):
    x = int(input()[2:])
    if x <= 90:
        cnt += 1
print(cnt)
