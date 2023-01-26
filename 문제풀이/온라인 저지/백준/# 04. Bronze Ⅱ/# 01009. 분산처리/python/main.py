import io, os

lines = io.BytesIO(os.read(0, os.fstat(0).st_size)).readlines()[1:]
com_numbers = [[10], [1], [6, 2, 4, 8], [1, 3, 9, 7], [6, 4], [5], [6], [1, 7, 9, 3], [6, 8, 4, 2], [1, 9]]


def main():
    answer = '\n'.join(str(get_com_number(line)) for line in lines)
    print(answer, end='')


def get_com_number(line):
    a, b = map(int, line.split())
    a %= 10
    return com_numbers[a][b % len(com_numbers[a])]


if __name__ == '__main__':
    main()
