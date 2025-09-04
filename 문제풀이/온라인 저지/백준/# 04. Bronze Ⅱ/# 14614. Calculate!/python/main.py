a, b, c = map(int, input().split())

if c % 2:
    a ^= b
print(a, end = '')
