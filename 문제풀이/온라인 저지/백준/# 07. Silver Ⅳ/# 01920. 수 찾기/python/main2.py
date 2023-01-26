a = None


def main():
    global a
    input()
    a = sorted(map(int, input().split()))
    input()
    answer = '\n'.join(binary_search(x) for x in map(int, input().split()))
    print(answer, end='')


def binary_search(x):
    lt = 0
    rt = len(a) - 1

    while lt <= rt:
        mid = (lt + rt) // 2
        if a[mid] == x:
            return '1'
        elif a[mid] > x:
            rt = mid - 1
        else:
            lt = mid + 1

    return '0'


if __name__ == '__main__':
    main()
