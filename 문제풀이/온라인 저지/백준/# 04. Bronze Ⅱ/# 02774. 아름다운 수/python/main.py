import sys

input = sys.stdin.readline
print = sys.stdout.write
answer = []

t = int(input())

for i in range(t):
    answer.append(str(len(set(input().rstrip()))))
print('\n'.join(answer))
