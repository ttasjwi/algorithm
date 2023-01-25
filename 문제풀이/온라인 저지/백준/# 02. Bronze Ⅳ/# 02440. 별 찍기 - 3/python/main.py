import sys

print = sys.stdout.write

n = int(input())
answer = '\n'.join('*' * i for i in range(n, 1 - 1, -1))
print(answer)

