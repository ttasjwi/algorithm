arr = input().split()

answer = ''
max_len = -1

for word in arr:
    len_word = len(word)
    if len_word > max_len:
        answer = word
        max_len = len_word
print(answer)

