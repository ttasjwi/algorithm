num = int(input())

answer = 0

for n in range(1, num + 1):
    s = 0
    tmp = n
    while tmp > 0:
        s += tmp % 10
        tmp //= 10
    if num - s == n:
        answer = n
        break
print(answer)
