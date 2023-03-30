n, m = map(lambda x: [int(ch) for ch in x], input().split())
if n[0] == 0 or m[0] == 0:
    print(0)
else:
    sum = 0
    for x in n:
        for y in m:
           sum += x * y
    print(sum)
