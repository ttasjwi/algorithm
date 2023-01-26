import io, os, sys

print = sys.stdout.write


def main():
    lines = io.BytesIO(os.read(0, os.fstat(0).st_size)).readlines()[1:]
    answer = '\n'.join(make_line(idx, line) for idx, line in enumerate(lines))
    print(answer)


def make_line(idx, line):
    a, b = map(int, line.split())
    return f'Case #{idx + 1}: {a} + {b} = {a + b}'


if __name__ == '__main__':
    main()
