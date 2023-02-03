answer = []
for ch in input():
    code = ord(ch)
    if 65 <= code <= 90:
        answer.append(chr(code + 32))
    else:
        answer.append(chr(code - 32))
print(''.join(answer))
