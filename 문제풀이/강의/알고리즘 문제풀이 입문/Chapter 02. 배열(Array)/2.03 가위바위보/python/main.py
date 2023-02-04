input()
answer = []
for a, b in zip(input().split(), input().split()):
    if a == b:
        answer.append('D')
    else:
        if (a == '1' and b == '3') or (a == '2' and b == '1') or (a == '3' and b == '2'):
            answer.append('A')
        else:
            answer.append('B')
print('\n'.join(answer), end='')
