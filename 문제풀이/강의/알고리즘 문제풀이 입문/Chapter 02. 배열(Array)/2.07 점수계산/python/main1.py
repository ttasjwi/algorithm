input()

answer = 0
bonus = 0
for point in input().split():
    if point == '1':
        bonus += 1
        answer += bonus
    else:
        bonus = 0
print(answer, end='')
