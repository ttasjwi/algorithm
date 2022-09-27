import sys

print = sys.stdout.write

number_existence = [None] * 2_000_001
_, *numbers = map(int, sys.stdin.buffer.read().rstrip().split())

for number in numbers:
    number = int(input())
    number_existence[number + 1_000_000] = True


for i in range(2_000_001):
    if number_existence[i]:
        print(str(i - 1_000_000))
        print('\n')
