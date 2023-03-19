k = int(input())
password = input()

# 라인 단위로 쪼개기
line_cnt = len(password) // k
lines = []
for i in range(line_cnt):
    line = password[k * i:k * (i+1)]
    if i % 2 == 0:
        lines.append(line)
    else:
        lines.append(line[::-1])

# 각 라인을 왼쪽 열부터 순서대로 결합
answer = ''.join(lines[c][r] for r in range(k) for c in range(line_cnt))
print(answer)
