n = int(input())
scores = map(int, input().split())

total = 0
bonus = 0
for score in scores:
    if score == 1:
        bonus += 1
        total += bonus
    else:
        bonus = 0
print(total)
