import sys

input_int = lambda: int(sys.stdin.readline().rstrip())


def main():
    a = input_int()
    b = input_int()
    c = input_int()
    answer = solution(a, b, c)
    print(answer, end='')


def solution(a, b, c):
    if a + b + c != 180:
        return 'Error'
    if a == b == c:  # 정삼각형
        return 'Equilateral'
    if a == b or b == c or c == a:  # 이등변 삼각형
        return 'Isosceles'
    return 'Scalene'


main()
