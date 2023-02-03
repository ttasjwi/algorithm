input()
s = input().rstrip().replace('#', '1').replace('*', '0')
answer = ''.join(chr(int(s[i:i+7], 2)) for i in range(0, len(s), 7))
print(answer, end='')
