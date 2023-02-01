import sys

input = sys.stdin.readline

deq = []
answer = []
for line in range(int(input())):
    command = list(input().rstrip().split())
    result = ''
    if command[0] == 'push_front':
        deq.insert(0, command[1])
    elif command[0] == 'push_back':
        deq.append(command[1])
    elif command[0] == 'pop_front':
        answer.append(deq.pop(0) if deq else '-1')
    elif command[0] == 'pop_back':
        answer.append(deq.pop() if deq else '-1')
    elif command[0] == 'size':
        answer.append(str(len(deq)))
    elif command[0] == 'empty':
        answer.append('0' if deq else '1')
    elif command[0] == 'front':
        answer.append(deq[0] if deq else '-1')
    else:
        answer.append(deq[-1] if deq else '-1')

print('\n'.join(answer), end='')
