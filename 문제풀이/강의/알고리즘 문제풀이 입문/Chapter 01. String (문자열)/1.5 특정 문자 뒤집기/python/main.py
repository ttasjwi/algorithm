word = list(input())
lt = 0
rt = len(word) - 1

while lt < rt:
    if not word[lt].isalpha():
        lt += 1
    elif not word[rt].isalpha():
        rt -= 1
    else:
        word[lt], word[rt] = word[rt], word[lt]
        lt += 1
        rt -= 1

print(''.join(word), end='')
