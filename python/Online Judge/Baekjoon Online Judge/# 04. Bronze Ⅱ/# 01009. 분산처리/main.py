import sys

input = lambda: sys.stdin.readline().rstrip()

com_numbers = [
    [10],  # a를 10으로 나눈 나머지가 0일 때는 10번 컴퓨터
    [1],  # 1
    [6, 2, 4, 8],  # 2
    [1, 3, 9, 7],  # 3
    [6, 4],  # 4
    [5],  # 5
    [6],  # 6
    [1, 7, 9, 3],  # 7
    [6, 8, 4, 2],  # 8
    [1, 9]  # 9
]

t = int(input())
for i in range(t):
    a, b = map(int, input().split())
    a %= 10
    print(com_numbers[a][b % len(com_numbers[a])])

