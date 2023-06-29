a, b, c = map(int, input().split(sep=':'))
combinations = [(a, b, c), (a, c, b), (b, a, c), (b, c, a), (c, a, b), (c, b, a)]

count = 0
for h, m, s in combinations:
    if 0 < h <= 12 and 0 <= m < 60 and 0 <= s < 60:
        count += 1
print(count)
