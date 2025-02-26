from functools import cmp_to_key


def solution(numbers):
    return str(int(''.join(sorted([str(number) for number in numbers], key=cmp_to_key(compare)))))


def compare(a, b):
    # 두 숫자 문자 a,b 을 앞 뒤로 붙임
    x = a + b
    y = b + a

    # a 를 앞에 붙인게 더 크면, a 를 앞으로 두기
    if x > y:
        return -1

    # b 를 앞에 붙인게 더 크면, b 를 앞으로 두기
    elif x < y:
        return 1
    else:
        return 0
