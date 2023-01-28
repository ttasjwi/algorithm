import io, os, sys

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
print = sys.stdout.write

current = 0
answer = []
while True:
    n, m = map(int, input().decode().split())

    if n == 0 and m == 0:
        break

    a = [int(input()) for _ in range(n)]
    b = [int(input()) for _ in range(m)]

    p1, p2 = 0, 0
    count = 0
    while p1 < n and p2 < m:
        if a[p1] == b[p2]:
            count += 1
            p1 += 1
            p2 += 1
        elif a[p1] < b[p2]:
            p1 += 1
        else:
            p2 += 1
    answer.append(str(count))

answer = '\n'.join(answer)
print(answer)
