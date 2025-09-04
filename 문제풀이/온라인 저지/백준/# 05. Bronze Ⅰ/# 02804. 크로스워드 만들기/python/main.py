import sys

print = sys.stdout.write
def find_cross_row_col(word_a, word_b):
    char_b_set = set(word_b)
    for c, char_a in enumerate(word_a):
        if char_a in char_b_set:
            cross_col = c
            for r, char_b in enumerate(word_b):
                if char_b == char_a:
                    cross_row = r
                    return cross_row, cross_col


word_a, word_b = input().split()
matrix = [['.' for _ in range(len(word_a))] for _ in range(len(word_b))]
cross_row, cross_col = find_cross_row_col(word_a, word_b)

for i, char_a in enumerate(word_a):
    matrix[cross_row][i] = char_a
for i, char_b in enumerate(word_b):
    matrix[i][cross_col] = char_b
answer = '\n'.join(map(lambda l: ''.join(l), matrix))
print(answer)
