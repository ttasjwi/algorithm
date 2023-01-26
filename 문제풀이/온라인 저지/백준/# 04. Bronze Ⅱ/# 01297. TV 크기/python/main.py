d, h, w = map(int, input().split())
r = d / (((h ** 2) + (w ** 2)) ** 0.5)

answer = ' '.join([str(int(h * r)), str(int(w * r))])
print(answer, end='')
