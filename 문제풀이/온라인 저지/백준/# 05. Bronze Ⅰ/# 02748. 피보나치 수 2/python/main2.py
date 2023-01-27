n = int(input())

before, current = 0, 1
for i in range(2, n + 1):
    before, current = current, before + current

print(current, end='')
