word = input()
answer = [word.find(chr(i)) for i in range(97, 123)]
print(*answer, sep=' ', end='')
