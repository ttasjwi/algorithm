word = input()
items = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
for item in items:
    word = word.replace(item, '#')
print(len(word))
