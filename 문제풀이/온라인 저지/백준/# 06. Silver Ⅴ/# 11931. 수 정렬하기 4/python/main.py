import sys

print = sys.stdout.write
input = sys.stdin.readline

n = int(input())
print('\n'.join(list(map(str, sorted([int(input()) for i in range(n)], reverse=True)))))
