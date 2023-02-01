import sys

print = sys.stdout.write


def solution(line):
    while '()' in line:
        line = line.replace('()', '')
    return 'NO' if line else 'YES'


answer = '\n'.join([solution(line.rstrip()) for line in sys.stdin.readlines()[1:]])
print(answer)
