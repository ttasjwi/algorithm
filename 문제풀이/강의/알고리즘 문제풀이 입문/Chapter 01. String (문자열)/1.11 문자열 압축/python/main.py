s = input()
answer = []

lt = 0
rt = 0
while lt < len(s):
    cnt = 0
    answer.append(s[lt])
    while rt < len(s) and s[lt] == s[rt]:
        rt += 1
        cnt += 1
    if cnt > 1:
        answer.append(str(cnt))
    lt = rt
print(''.join(answer), end='')
