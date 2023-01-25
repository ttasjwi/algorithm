a = int(input())
b = input()

answers = [int(n) * a for n in b[::-1]]
answers.append(a * int(b))
answers = '\n'.join(map(str, answers))
print(answers, end='')
