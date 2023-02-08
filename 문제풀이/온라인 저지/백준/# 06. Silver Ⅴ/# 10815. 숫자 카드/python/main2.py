import io, os, sys

lines = io.BytesIO(os.read(0, os.fstat(0).st_size)).read().splitlines()
print = sys.stdout.write

a = sorted(map(int, lines[1].split()))
b = list(map(int, lines[3].split()))

answer = []
for n in b:
    lt = 0
    rt = len(a) - 1
    flag = False
    while lt <= rt:
        mid = (lt + rt) // 2
        if a[mid] == n:
            flag = True
            break
        elif a[mid] > n:
            rt = mid - 1
        else:
            lt = mid + 1
    if flag:
        answer.append('1')
    else:
        answer.append('0')
print(' '.join(answer))
