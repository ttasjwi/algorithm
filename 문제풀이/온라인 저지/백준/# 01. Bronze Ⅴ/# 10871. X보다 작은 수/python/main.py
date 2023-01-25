n, x = map(int, input().split())
answer = ' '.join([i for i in input().split() if int(i) < x])
print(answer, end='')
