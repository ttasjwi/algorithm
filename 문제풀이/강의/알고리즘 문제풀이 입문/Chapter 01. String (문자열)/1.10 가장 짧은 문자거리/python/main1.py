s, t = input().split()
dis = [101 for i in range(len(s))]

before = -1
for i in range(s.find(t), len(s)):
    if s[i] == t:
        dis[i] = 0
        for j in range(i - 1, before, -1):
            if dis[j] > dis[j + 1] + 1:
                dis[j] = dis[j + 1] + 1
            else:
                break
        before = i
    else:
        dis[i] = dis[i - 1] + 1
print(' '.join(map(str, dis)), end='')
