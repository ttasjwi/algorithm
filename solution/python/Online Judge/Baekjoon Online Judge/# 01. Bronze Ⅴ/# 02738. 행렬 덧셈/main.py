import sys

input = lambda: sys.stdin.readline().rstrip()

n, m = map(int, input().split())

list1 = [[int(x) for x in input().split()] for _ in range(n)]
list2 = [[int(x) for x in input().split()] for _ in range(n)]
result = [[list1[i][j] + list2[i][j] for j in range(m)] for i in range(n)]

for row in result:
    print(' '.join(str(element) for element in row))
