word = input()

counts = {'0': 0, '1': 0}

for i in range(len(word)):
    if i + 1 == len(word) or word[i + 1] != word[i]:
        counts[word[i]] += 1

answer = min(counts.values())
print(answer, end='')
