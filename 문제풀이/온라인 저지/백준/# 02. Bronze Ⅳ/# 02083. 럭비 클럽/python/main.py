import io
import os
import sys

print = sys.stdout.write


def main():
    lines = io.BytesIO(os.read(0, os.fstat(0).st_size)).readlines()[:-1]
    answer = '\n'.join([get_result(line.decode()) for line in lines])
    print(answer)


def get_result(line):
    name, age, weight = line.split()
    return f'{name} Senior' if int(age) > 17 or int(weight) >= 80 else f'{name} Junior'


if __name__ == '__main__':
    main()
