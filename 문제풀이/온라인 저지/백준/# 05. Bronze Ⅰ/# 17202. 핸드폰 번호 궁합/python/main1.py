def foo(x):
    y = []
    for i in range(len(x) - 1):
        y.append((x[i] + x[i + 1]) % 10)
    return y

# 입력
a = [int(ch) for ch in input()]
b = [int(ch) for ch in input()]

# 입력값들을 순서대로 교차해서 리스트에 추가
x = []
for i in range(len(a)):
    x.append(a[i])
    x.append(b[i])

# 리스트의 길이가 2가 넘는 동안 반복하여 핸드폰 번호 처리
while len(x) > 2:
    x = foo(x)

# 출력
print(''.join(map(str, x)))
