import sys

input = lambda: sys.stdin.readline().rstrip()

find_char = 'aeiouAEIOU'
while True:
    word = input()
    if word == '#':
        break
    else:
        count = 0
        for char in word:
            if char in find_char:
                count += 1
        print(count)
