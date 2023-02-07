n = int(input())

if n <= 99:
    answer = n
else:
    answer = 99
    for k in range(100, n + 1):
        if k // 100 + k % 10 == k // 10 % 10 * 2:
            answer += 1
print(answer)
