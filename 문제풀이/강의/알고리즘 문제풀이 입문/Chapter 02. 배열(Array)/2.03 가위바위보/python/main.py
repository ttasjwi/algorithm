input()
answer = []
for a, b in zip(input().split(), input().split()):
    # 비기는 경우
    if a == b:
        answer.append('D')
    else:
        # A가 이기는 경우
        # 가위/보, 바위/가위, # 보/바위
        if (a == '1' and b == '3') or (a == '2' and b == '1') or (a == '3' and b == '2'):
            answer.append('A')

        # B가 이기는 경우 : 그 외
        else:
            answer.append('B')
print('\n'.join(answer), end='')
