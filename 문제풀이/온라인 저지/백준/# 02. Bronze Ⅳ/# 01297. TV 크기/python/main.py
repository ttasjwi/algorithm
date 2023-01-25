d, h_ratio, w_ratio = map(int, input().split())
x = d / (((h_ratio ** 2) + (w_ratio ** 2)) ** 0.5)

answer = ' '.join([str(int(h_ratio * x)), str(int(w_ratio * x))])
print(answer, end='')
