h, m = map(int, input().split())
m += int(input())

if m >= 60:
    h += m // 60
    m = m % 60
if h >= 24:
    h = h % 24
answer = ' '.join([str(h), str(m)])
print(answer, end='')
