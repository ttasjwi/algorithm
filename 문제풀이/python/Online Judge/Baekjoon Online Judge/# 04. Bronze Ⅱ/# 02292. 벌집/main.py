n = int(input())

level = 1
level_end = 1
while n > level_end:
    level_end += 6 * level
    level += 1
print(level, end='')
