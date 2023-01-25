import io, os, sys

inputs = io.BytesIO(os.read(0, os.fstat(0).st_size)).readlines
print = sys.stdout.write


def main():
    answer = '\n'.join(str(get_sum(line)) for line in inputs()[1:])
    print(answer)


def get_sum(line: str):
    a, b = map(int, line.split())
    return a + b


if __name__ == '__main__':
    main()
