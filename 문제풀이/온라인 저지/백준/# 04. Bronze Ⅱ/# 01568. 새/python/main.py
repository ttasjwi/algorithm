n = int(input())

t = 0
bird = n
cur = 1

while bird > 0:
    if bird < cur:
        cur = 1
    bird -= cur
    cur += 1
    t += 1
print(t)
