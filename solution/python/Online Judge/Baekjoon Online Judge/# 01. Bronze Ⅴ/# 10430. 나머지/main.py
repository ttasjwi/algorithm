a, b, c = map(int, input().split())
result = (
    (a + b) % c,
    ((a % c) + (b % c)) % c,
    (a * b) % c,
    ((a % c) * (b % c)) % c
)
print(*result, sep='\n', end='')
