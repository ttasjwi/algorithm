# 입력을 짝, 홀 인덱스에 번갈아가며 저장
x = [0] * 16
x[::2] = map(int, input())
x[1::2] = map(int, input())

# 리스트의 길이가 2가 넘는 동안 반복하여 핸드폰 번호 처리
while len(x) > 2:
    x = [(i + j) % 10 for i, j in zip(x, x[1:])]

print(''.join(map(str, x)))
