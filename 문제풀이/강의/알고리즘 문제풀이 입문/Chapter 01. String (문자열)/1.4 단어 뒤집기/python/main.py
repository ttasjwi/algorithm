n = int(input())
answer = [input()[::-1] for i in range(n)]
print('\n'.join(answer), end='')
