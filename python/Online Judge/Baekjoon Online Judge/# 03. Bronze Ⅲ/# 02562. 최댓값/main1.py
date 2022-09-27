import sys

int_input = lambda: int(sys.stdin.readline().rstrip())

max_value = 0
max_pos = -1
for i in range(9):
    value = int_input()
    if value > max_value:
        max_value = value
        max_pos = i+1
print(max_value, max_pos, sep='\n', end='')

