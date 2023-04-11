n = int(input())
answer = [(n-i) * ' ' + (2 * i - 1) * '*' for i in range(1, n+1)]
answer += answer[-2::-1]
print('\n'.join(answer))
