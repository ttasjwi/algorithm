min_odd = 101
total = 0
for _ in range(7):
    k = int(input())
    if k % 2:
        total += k
        if min_odd > k:
            min_odd = k
if min_odd == 101:
    print(-1)
    exit(0)
print(total)
print(min_odd)
