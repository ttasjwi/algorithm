input()
customers = list(map(int, input().split()))
usable = [True] * 100

count = 0
for customer in customers:
    if usable[customer - 1]:
        usable[customer - 1] = False
    else:
        count += 1
print(count)
