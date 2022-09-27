a, b = map(int, input().split())
answer = ((a + b) * (abs(b - a) + 1)) // 2
print(answer, end='')
