import sys

s = set(map(lambda x: x[0], sys.stdin.readlines()))
print('GLOBAL' if {'k', 'l', 'p'} == s else 'PONIX')
