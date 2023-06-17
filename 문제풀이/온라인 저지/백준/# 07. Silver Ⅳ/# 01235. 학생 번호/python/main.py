n = int(input())
nums = [input() for _ in range(n)]

for k in range(1, 101):
    s = set([num[:-1 - k:-1] for num in nums])
    if len(s) == n:
        print(k)
        exit(0)
