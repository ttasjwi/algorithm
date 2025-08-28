n = int(input())

answer = []
for i in range(n):
    if i == 0 or i == 1:
        answer.append(1)
    else:
        answer.append(answer[i-2] + answer[i-1])
print(*answer, end = '', sep=' ')
