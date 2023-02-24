import sys

input = sys.stdin.readline
print = sys.stdout.write

n, m = map(int, input().split())
dic = {}

for _ in range(n):
    site, pw = input().split()
    dic[site] = pw
for _ in range(m):
    print(dic[input().rstrip()])
    print('\n')
