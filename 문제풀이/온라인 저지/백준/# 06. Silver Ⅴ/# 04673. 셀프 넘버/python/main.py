import sys

print = sys.stdout.write


def main():
    check = [False] * 10001

    def d(k):
        j = k
        while j > 0:
            k += j % 10
            j //= 10
        if k > 10000 or check[k]:
            return
        check[k] = True
        d(k)

    for i in range(1, 10001):
        if not check[i]:
            d(i)
            print(str(i) + '\n')


if __name__ == '__main__':
    main()
