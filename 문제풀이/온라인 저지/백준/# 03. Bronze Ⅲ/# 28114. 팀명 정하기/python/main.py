p, y, s = [], [], []

for _ in range(3):
    i, j, k = input().split()
    p.append(int(i))
    y.append(int(j))
    s.append(k)
print(''.join(map(str, sorted(map(lambda x: x % 100, y)))))
print(''.join(map(lambda x: s[p.index(x)][0], sorted(p, reverse=True))))

