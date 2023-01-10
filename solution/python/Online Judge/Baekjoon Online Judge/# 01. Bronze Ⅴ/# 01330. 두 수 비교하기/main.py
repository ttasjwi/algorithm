def main():
    a, b = input_numbers()  # 숫자를 입력받아 튜플에 저장
    answer = solution(a, b)  # 결과 문자열을 얻어옴
    print(answer, end='')  # 출력


# 숫자를 입력받음
def input_numbers():
    return map(int, input().split())


# 결과 문자열 생성
def solution(a, b):
    if a > b:
        return '>'
    elif a < b:
        return '<'
    else:
        return '=='


main()
