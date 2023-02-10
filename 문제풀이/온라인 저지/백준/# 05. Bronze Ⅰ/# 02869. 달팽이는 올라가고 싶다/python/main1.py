# 시간 초과
a, b, v = map(int, input().split())
answer = 1
while v > 0:
    v -= a
    if v <= 0:
        break
    v += b
    answer += 1
print(answer)
