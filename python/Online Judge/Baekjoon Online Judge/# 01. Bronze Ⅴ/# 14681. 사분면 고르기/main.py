def main():
    x = int(input())
    y = int(input())
    answer = solution(x, y)
    print(answer, end='')


def solution(x, y):
    if y > 0:
        if x > 0:
            return '1'
        return '2'
    else:
        if x < 0:
            return '3'
        return '4'


main()
