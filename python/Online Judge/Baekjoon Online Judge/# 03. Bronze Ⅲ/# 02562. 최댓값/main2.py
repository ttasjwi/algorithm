import sys

int_input = lambda: int(sys.stdin.readline().rstrip())

numbers = [int_input() for _ in range(9)]
max_value = max(numbers)
max_pos = numbers.index(max_value) + 1
print(max_value, max_pos, sep='\n', end='')
