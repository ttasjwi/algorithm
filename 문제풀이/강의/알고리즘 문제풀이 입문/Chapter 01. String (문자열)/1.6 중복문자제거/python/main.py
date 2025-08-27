s = set()
answer = []
for ch in input():
    if ch not in s:
        answer.append(ch)
        s.add(ch)
print(''.join(answer))
