word = input().lower()
lt = 0
rt = len(word) - 1

flag = True
while lt < rt:
    if word[lt] != word[rt]:
        flag = False
        break
    lt += 1
    rt -= 1
print('YES' if flag else 'NO', end='')

