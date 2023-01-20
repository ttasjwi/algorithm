h, m, s = map(int, input().split())
d = int(input())
total = h * 60 * 60 + m * 60 + s + d
h, m, s = (total // 3600) % 24, (total // 60) % 60, total % 60
print(h, m, s, sep=' ', end='')
