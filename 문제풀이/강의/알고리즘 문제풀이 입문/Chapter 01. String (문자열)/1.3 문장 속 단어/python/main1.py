max = -1
max_str = ''
for word in input().split():
    if len(word) > max:
        max = len(word)
        max_str = word
print(max_str, end='')
