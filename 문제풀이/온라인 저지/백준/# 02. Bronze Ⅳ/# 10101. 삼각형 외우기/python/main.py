a, b, c = int(input()), int(input()), int(input())

if a + b + c != 180:
    answer = 'Error'
elif a == b == c:  # 정삼각형
    answer = 'Equilateral'
elif a == b or b == c or c == a:  # 이등변 삼각형
    answer = 'Isosceles'
else:
    answer = 'Scalene'

print(answer, end='')
