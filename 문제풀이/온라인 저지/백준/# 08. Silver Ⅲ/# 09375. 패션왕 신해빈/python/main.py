import sys

input = sys.stdin.readline
print = sys.stdout.write

answers = []
for _ in range(int(input())):
    n = int(input())
    counter = {}
    if n == 0:
        answers.append('0')
        continue
    for _ in range(n):
        _, part = input().split()
        if part in counter:
            counter[part] += 1
        else:
            counter[part] = 1
        product = 1
        for v in counter.values():
            product *= (v + 1)
    answers.append(str(product - 1))
print('\n'.join(answers))
