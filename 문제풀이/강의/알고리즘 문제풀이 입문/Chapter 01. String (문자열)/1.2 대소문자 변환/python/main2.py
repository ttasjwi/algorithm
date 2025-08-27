answer = []
for ch in input():
    code = ord(ch)
    if code >= 97:
        code -= 32
    else:
        code += 32
    answer.append(chr(code))
print(''.join(answer))
