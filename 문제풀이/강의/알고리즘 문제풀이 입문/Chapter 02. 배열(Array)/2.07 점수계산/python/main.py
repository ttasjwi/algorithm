input()

total = 0
combo = 0
for ch in input().split():
    if ch == '1':
        combo += 1
        total += combo
    else:
        combo = 0
print(total, end='')
