import io, os, sys

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
print = sys.stdout.write

current = 0
answer = []
while True:
    n, m = map(int, input().decode().split())

    if n == 0 and m == 0:
        break

    a = set(int(input()) for _ in range(n))
    b = set(int(input()) for _ in range(m))
    answer.append(str(len(a & b)))

answer = '\n'.join(answer)
print(answer)
