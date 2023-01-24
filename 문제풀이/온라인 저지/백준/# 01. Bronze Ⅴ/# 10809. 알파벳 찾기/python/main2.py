s = input()
answer = ' '.join(str(s.find(chr(i))) for i in range(97, 123))
print(answer, end='')
