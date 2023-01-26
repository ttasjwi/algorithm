import io, os, sys

print = sys.stdout.write
cache = {}


def main():
    _, *numbers = map(int, io.BytesIO(os.read(0, os.fstat(0).st_size)).read().decode().split())
    answer = '\n'.join(get_result(n) for n in numbers)
    print(answer)


def get_result(n):
    if n in cache:
        return cache[n]

    result = 0
    for i in range(2, n + 1):
        copy_n = n

        while copy_n % i == 0:
            result += 1
            copy_n //= i

    cache[n] = str(result)
    return cache[n]


if __name__ == '__main__':
    main()
