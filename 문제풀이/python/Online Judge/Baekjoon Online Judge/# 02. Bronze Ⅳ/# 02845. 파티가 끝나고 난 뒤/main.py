l, p = map(int, input().split())
n = l * p  # 실제 사람 수
results = [int(x) - n for x in input().split()]  # 오차들
print(*results, sep=' ', end='')
