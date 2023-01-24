a, b, c = map(int, input().split())

answer = '\n'.join([
    str((a + b) % c),
    str(((a % c) + (b % c)) % c),
    str((a * b) % c),
    str(((a % c) * (b % c)) % c)
])

print(answer, end='')
