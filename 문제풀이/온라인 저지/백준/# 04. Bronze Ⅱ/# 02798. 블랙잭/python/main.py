def main():
    n, m = map(int, input().split())
    numbers = list(map(int, input().split()))

    answer = search(numbers, n, m)
    print(answer, end='')


def search(numbers, n, m):
    result = 0
    for i in range(0, n - 2):
        if numbers[i] >= m:
            continue
        for j in range(i + 1, n - 1):
            if numbers[i] + numbers[j] >= m:
                continue
            for k in range(j + 1, n):
                sum = numbers[i] + numbers[j] + numbers[k]
                if sum == m:
                    return sum
                if result < sum < m:
                    result = sum
    return result


if __name__ == '__main__':
    main()
