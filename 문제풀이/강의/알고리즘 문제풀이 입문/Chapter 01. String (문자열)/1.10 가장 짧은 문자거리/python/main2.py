s, t = input().split()
dis = [0] * len(s)

lt_dis = 100
rt_dis = 100

for i in range(len(dis)):
    if s[i] == t:
        lt_dis = 0
    dis[i] = lt_dis
    lt_dis += 1
for i in range(len(dis) - 1, -1, -1):
    if s[i] == t:
        rt_dis = 0
    dis[i] = min(rt_dis, dis[i])
    rt_dis += 1
print(' '.join(map(str, dis)), end='')
