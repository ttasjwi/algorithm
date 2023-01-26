def main():
    n = int(input())
    answer = '\n'.join(make_line(i, n) for i in range(1, n + 1))
    print(answer, end='')


def make_line(i, n):
    if i == 1:
        return ' ' * (n - 1) + '*'
    if i == n:
        return '*' * (2 * n - 1)
    else:
        return ' ' * (n - i) + '*' + ' ' * (2 * i - 3) + '*'


if __name__ == '__main__':
    main()
