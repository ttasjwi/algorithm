def main():
    a, b = map(int, input().split())
    answer = solution(a,b)
    print(answer, end='')


def solution(a, b):
    if a > b:
        return '>'
    elif a < b:
        return '<'
    else:
        return '=='


main()
