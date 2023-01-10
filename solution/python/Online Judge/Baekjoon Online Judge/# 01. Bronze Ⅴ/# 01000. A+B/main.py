def main():
    numbers = input_numbers()
    answer = get_sum(numbers)
    print(answer)
    return


# 정수들 입력
def input_numbers():
    return list(map(int, input().split()))


# 정수들의 합을 구함
def get_sum(numbers):
    return sum(numbers)


main()
