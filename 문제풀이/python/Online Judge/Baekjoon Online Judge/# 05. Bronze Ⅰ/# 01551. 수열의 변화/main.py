def main():
    _, k = map(int, input().split())
    numbers = list(map(int, input().split(sep=',')))
    change_k(numbers, k)
    print(*numbers, sep=',', end='')


def change(numbers):
    for i in range(0, len(numbers) - 1):
        numbers[i] = numbers[i + 1] - numbers[i]
    numbers.pop()


def change_k(numbers, k):
    for _ in range(k):
        change(numbers)


main()
