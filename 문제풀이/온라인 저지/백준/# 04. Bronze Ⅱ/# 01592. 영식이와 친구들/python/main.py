n, m, l = map(int, input().split())
pass_counts = [0] * n
total_counts = -1
i = 0
while True:
    pass_counts[i] += 1
    total_counts += 1
    if pass_counts[i] == m:
        break
    i = (i + l) % n if pass_counts[i] % 2 else (i - l) % n
print(total_counts)
