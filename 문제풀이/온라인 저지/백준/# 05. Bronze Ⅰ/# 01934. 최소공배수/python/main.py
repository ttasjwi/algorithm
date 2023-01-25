import io, os, sys

lines = io.BytesIO(os.read(0, os.fstat(0).st_size)).readlines()[1:]
print = sys.stdout.write


def main():
    answer = '\n'.join(str(get_result(line.decode())) for line in lines)
    print(answer)


def get_result(line: str):
    a, b = map(int, line.split())
    a, b = (a, b) if a >= b else (b, a)
    return a * b // gcd(a, b)


def gcd(a, b):
    r = a % b
    return b if r == 0 else gcd(b, r)


if __name__ == '__main__':
    main()
