input()
points = input().split()
lt = 0
answer = 0
while lt < len(points):
    rt = lt
    bonus = 0
    while rt < len(points) and points[rt] == '1':
        bonus += 1
        answer += bonus
        rt += 1
    lt = rt + 1
print(answer)
