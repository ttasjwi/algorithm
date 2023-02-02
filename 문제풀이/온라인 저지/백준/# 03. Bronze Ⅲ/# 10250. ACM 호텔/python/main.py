import io, os


def solution(line):
    h, w, n = map(int, line.split())
    div, mod = divmod(n - 1, h)
    return str((mod + 1) * 100 + (div + 1))


result = '\n'.join(
    solution(line) for line in io.BytesIO(os.read(0, os.fstat(0).st_size)).read().decode().rstrip().split(sep='\n')[1:])
print(result, end='')
