import io, os, sys

inputs = io.BytesIO(os.read(0, os.fstat(0).st_size))
print = sys.stdout.write


def main():
    answer = '\n'.join(str(get_share(line)) for line in inputs)
    print(answer)


def get_share(line: str):
    s, n = map(int, line.split())
    return n // (s + 1)


if __name__ == '__main__':
    main()
