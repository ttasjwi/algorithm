def main():
    n = int(input())
    print(find_number(n), end='')


def find_number(n):
    if n == 1:
        return 666

    count = 1
    prev_digit = 0  # 선두에 오는 자릿수(천의자리 이후의 수)
    num = None  # 선두에 오는 자릿수를 제외한 나머지 수(1~1000)

    while True:
        # 앞 자릿수가 X...666 일 경우(예 : 666_000, 1_666_004)
        if prev_digit % 1000 == 666:
            num = 0
            for i in range(1000):
                if count == n:
                    return prev_digit * 1000 + num
                num += 1
                count += 1
            prev_digit += 1

        # 앞 자릿수가 X...66 일 경우 (예 : 66_000, 166_600)
        elif prev_digit % 100 == 66:
            num = 600
            for i in range(100):
                if count == n:
                    return prev_digit * 1000 + num
                num += 1
                count += 1
            prev_digit += 1

        # 앞 자릿수가 X...6 일 경우 (예 : 6_660, 16_663)
        elif prev_digit % 10 == 6:
            num = 660
            for i in range(10):
                if count == n:
                    return prev_digit * 1000 + num
                num += 1
                count += 1
            prev_digit += 1

        # 그 외 (예: 241_666, 23_666, 2_111_666, ...)
        else:
            num = 666
            if count == n:
                return prev_digit * 1000 + num
            count += 1
            prev_digit += 1


if __name__ == '__main__':
    main()
