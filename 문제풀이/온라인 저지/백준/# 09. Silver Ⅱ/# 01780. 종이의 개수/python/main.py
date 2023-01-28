import io, os, sys

n = 0
matrix = None
counter = [0, 0, 0]


def main():
    input_args()
    search(0, 0, n)
    answer = '\n'.join(map(str, counter))
    sys.stdout.write(answer)


def input_args():
    global n, matrix
    lines = io.BytesIO(os.read(0, os.fstat(0).st_size)).read().decode().rstrip().split('\n')
    n, matrix = int(lines[0]), [list(map(int, line.split())) for line in lines[1:]]


def search(r, c, l):
    number = matrix[r][c]

    for i in range(r, r + l):
        for j in range(c, c + l):
            if matrix[i][j] != number:
                if l == 3:
                    for a in range(r, r + l):
                        for b in range(c, c + l):
                            counter[matrix[a][b] + 1] += 1
                    return
                sl = l//3
                for a in range(r, r + l, sl):
                    for b in range(c, c + l, sl):
                        search(a, b, sl)
                return

    counter[number + 1] += 1
    return


if __name__ == '__main__':
    main()
