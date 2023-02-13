n = 0
r = 0
c = 0
find = False
count = -1


def main():
    global n, r, c
    n, r, c = map(int, input().split())
    divide_and_conquer(0, 0, 2 ** n)
    print(count)


def divide_and_conquer(row, column, length):
    global find, count
    next_length = length >> 1
    for i in range(row, row + next_length + 1, next_length):
        for j in range(column, column + next_length + 1, next_length):
            if find:
                return
            if i <= r < i+next_length and j <= c < j + next_length:
                if next_length == 1:
                    find = True
                    count += 1
                    return
                divide_and_conquer(i, j, next_length)
            else:
                count += next_length ** 2


main()
