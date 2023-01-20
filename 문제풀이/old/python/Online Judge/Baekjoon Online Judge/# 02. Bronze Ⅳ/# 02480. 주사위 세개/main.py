def main():
    a, b, c = sorted(map(int, input().split()))
    price = solution(a, b, c)
    print(price, end='')


def solution(a, b, c):
    if a == c:  # 세 눈이 모두 같다
        return 10000 + a * 1000
    elif a != b and b != c: # 모두 다르다
        return c * 100
    else: # 두 가지가 같을 때
        return 1000 + b * 100


main()
