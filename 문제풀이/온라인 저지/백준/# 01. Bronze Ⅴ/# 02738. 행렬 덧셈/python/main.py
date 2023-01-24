import io
import os
import sys

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
print = sys.stdout.write

n, m = map(int, input().split())

matrix_a = [input().split() for _ in range(n)]
matrix_b = [input().split() for _ in range(n)]

answer = '\n'.join([' '.join([str(int(a) + int(b)) for a, b in zip(x, y)]) for x, y in zip(matrix_a, matrix_b)])
print(answer)
