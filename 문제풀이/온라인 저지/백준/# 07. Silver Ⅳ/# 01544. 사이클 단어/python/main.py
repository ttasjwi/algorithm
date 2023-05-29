word_set = set()

n = int(input())

for _ in range(n):
    word = input()
    find = False
    for i in range(len(word)):
        tmp = word[i:] + word[0: i]
        if tmp in word_set:
            find = True
    if not find:
        word_set.add(word)
print(len(word_set))
