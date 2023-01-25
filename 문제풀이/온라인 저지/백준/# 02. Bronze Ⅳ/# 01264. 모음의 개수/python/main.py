import io, os, sys

print = sys.stdout.write
find_chars = 'aeiouAEIOU'


def main():
    lines = io.BytesIO(os.read(0, os.fstat(0).st_size)).readlines()[:-1]
    answer = '\n'.join(str(calculate_count(line.decode())) for line in lines)
    print(answer)


def calculate_count(line):
    count = 0
    for ch in line:
        if ch in find_chars:
            count += 1
    return count


if __name__ == '__main__':
    main()
