import sys

print = sys.stdout.write

input()
times = list(map(int, input().split()))

a, b = 0, 0
for time in times:
    a += (time // 30 + 1) * 10
    b += (time // 60 + 1) * 15
if a < b:
    print('Y ')
    print(str(a))
elif a == b:
    print('Y M ')
    print(str(a))
else:
    print('M ')
    print(str(b))
