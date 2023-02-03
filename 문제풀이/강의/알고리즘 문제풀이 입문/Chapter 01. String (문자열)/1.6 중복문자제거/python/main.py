
char_set = set()
answer = []
for ch in input():
    if ch not in char_set:
        answer.append(ch)
        char_set.add(ch)
print(''.join(answer))
