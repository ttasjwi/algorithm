word = input()
lt = 0
rt = 0
result = []
while rt < len(word) and word[lt] == word[rt]:
    count = 0
    while rt < len(word) and word[lt] == word[rt]:
        count += 1
        rt += 1
    result.append(word[lt])
    if count > 1:
        result.append(str(count))
    lt = rt
print(''.join(result), end='')
