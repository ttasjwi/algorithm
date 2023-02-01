import sys

input = sys.stdin.readline

stack = []
answer = []
for line in range(int(input())):
    command = list(input().rstrip().split())
    result = ''
    if command[0] == 'push':
        stack.append(int(command[1]))
    elif command[0] == 'pop':
        answer.append(str(stack.pop(-1)) if stack else '-1')
    elif command[0] == 'size':
        answer.append(str(len(stack)))
    elif command[0] == 'empty':
        answer.append('0' if stack else '1')
    else:
        answer.append(str(stack[-1]) if stack else '-1')

print('\n'.join(answer), end='')
