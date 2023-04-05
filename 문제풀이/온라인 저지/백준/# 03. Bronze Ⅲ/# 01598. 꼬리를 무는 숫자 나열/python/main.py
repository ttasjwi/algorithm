a, b = map(int, input().split())
r1, c1 = (a - 1) % 4, (a - 1) // 4
r2, c2 = (b - 1) % 4, (b - 1) // 4
print(abs(r2 - r1) + abs(c2 - c1))
