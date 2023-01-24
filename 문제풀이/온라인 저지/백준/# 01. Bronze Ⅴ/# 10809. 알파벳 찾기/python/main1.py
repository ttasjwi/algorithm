results = ['-1'] * 26
word = input()

for i in range(len(word)):
    index = ord(word[i]) - 97

    if results[index] == '-1':
        results[index] = str(i)

answer = ' '.join(results)
print(answer, end='')

