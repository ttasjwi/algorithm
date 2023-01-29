import io, os, sys

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
print = sys.stdout.write

numbers = [[0 for _ in range(15)] for _ in range(15)]
for r in range(15):
    for c in range(15):
        if r == 0 or c == 0:
            numbers[r][c] = c
        else:
            numbers[r][c] = numbers[r][c-1] + numbers[r-1][c]

t = int(input())

answers = []
while t > 0:
    k = int(input())
    n = int(input())
    answers.append(str(numbers[k][n]))
    t -= 1
answers = '\n'.join(answers)
print(answers)
