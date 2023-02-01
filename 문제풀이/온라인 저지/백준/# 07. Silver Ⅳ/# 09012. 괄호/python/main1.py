import io, os, sys

print = sys.stdout.write


def solution(line):
    stack = []

    for ch in line.rstrip():
        if ch == '(':
            stack.append(ch)
        elif not stack:
            return 'NO'
        else:
            stack.pop()

    return 'NO' if stack else 'YES'


answer = '\n'.join([solution(line) for line in sys.stdin.readlines()[1:]])
print(answer)
