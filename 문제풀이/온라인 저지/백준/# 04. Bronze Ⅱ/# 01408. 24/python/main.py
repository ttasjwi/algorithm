h1, m1, s1 = map(int, input().split(sep=':'))
h2, m2, s2 = map(int, input().split(sep=':'))

# 시간의 차
diff = (h2 - h1) * 60 * 60 + (m2 - m1) * 60 + (s2 - s1)

h, m, s = 0, 0, 0

# 차가 음수일 경우, 24시를 더해야함(다음날 완료되기 때문)
if diff < 0:
    diff += 24 * 60 * 60

h = diff // (60 * 60) # 시 분리
diff = diff % (60 * 60)
m = diff // 60 # 분 분리
s = diff % 60 # 초 분리
print(f'{h:02d}:{m:02d}:{s:02d}')
