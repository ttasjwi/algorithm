import sys


def solution(line):
    numbers = sorted(map(int, line.split()))
    return 'right' if numbers[0] ** 2 + numbers[1] ** 2 == numbers[2] ** 2 else 'wrong'


answer = '\n'.join(solution(line.rstrip()) for line in sys.stdin.readlines()[:-1])
print(answer, end='')
