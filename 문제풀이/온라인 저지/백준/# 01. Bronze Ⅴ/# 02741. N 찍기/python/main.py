import sys

print = sys.stdout.write

n = int(input())
answer = '\n'.join(str(i) for i in range(1, n+1))
print(answer)
