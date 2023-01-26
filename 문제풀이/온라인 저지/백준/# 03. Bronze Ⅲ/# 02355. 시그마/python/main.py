a, b = map(int, input().split())
answer = (abs(b - a) + 1) * (a + b) // 2
print(answer, end='')
