a, b = map(int, input().split())
answer = '\n'.join([
    str(a + b),
    str(a - b),
    str(a * b),
    str(a // b),
    str(a % b)
])
print(answer, end='')

