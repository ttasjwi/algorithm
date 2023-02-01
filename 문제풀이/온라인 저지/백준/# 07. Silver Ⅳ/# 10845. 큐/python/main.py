import sys

input = sys.stdin.readline

q = []
answer = []
for line in range(int(input())):
    command = list(input().rstrip().split())
    result = ''
    if command[0] == 'push':
        q.append(int(command[1]))
    elif command[0] == 'pop':
        answer.append(str(q.pop(0)) if q else '-1')
    elif command[0] == 'size':
        answer.append(str(len(q)))
    elif command[0] == 'empty':
        answer.append('0' if q else '1')
    elif command[0] == 'front':
        answer.append(str(q[0]) if q else '-1')
    else:
        answer.append(str(q[-1]) if q else '-1')

print('\n'.join(answer), end='')
