n = int(input())

answer = 0
cnt = 1

while True:
    if n % cnt == 0:
        answer += 1
    n -= cnt
    cnt += 1

    if n <= 0:
        break

print(answer, end='')

