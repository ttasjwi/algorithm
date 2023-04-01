counter1 = {}
counter2 = {}

for _ in range(3):
    x, y = map(int, input().split())
    if x not in counter1:
        counter1[x] = 1
    else:
        counter1[x] += 1
    if y not in counter2:
        counter2[y] = 1
    else:
        counter2[y] += 1

answer_x = 0
answer_y = 0
for x, count in counter1.items():
    if count == 1:
        answer_x = x
        break
for y, count in counter2.items():
    if count == 1:
        answer_y = y
        break
print(answer_x, answer_y, sep=' ')

