def main():
    n, k = map(int, input().split())
    init_n = n

    while count_bit(n) > k:
        n += n & (-n)
    print(n - init_n, end='')


def count_bit(n):
    count = 0
    while n > 0:
        if n % 2:
            count += 1
        n = n >> 1
    return count


if __name__ == '__main__':
    main()
