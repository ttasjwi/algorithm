
sx, sy = map(int, input().split())
ex, ey = map(int, input().split())
px, py = map(int, input().split())

if sx == ex:
    if sx == px and (sy < py < ey or ey < py < sy):
        answer = 2
    else:
        answer = 0
elif sy == ey:
    if sy == py and (sx < px < ex or ex < px < sx):
        answer = 2
    else:
        answer = 0
else:
    answer = 1
print(answer, end= '')
