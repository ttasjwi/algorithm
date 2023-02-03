from sys import stdin

input = stdin.readline

answer = '\n'.join(input().rstrip()[::-1] for _ in range(int(input())))
print(answer, end='')
