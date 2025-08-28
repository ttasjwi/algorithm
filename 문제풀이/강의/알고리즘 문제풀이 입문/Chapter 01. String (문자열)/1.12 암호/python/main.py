def change_to_bit(s):
    result = []
    for char in s:
        if char == '#':
            result.append('1')
        else:
            result.append('0')
    return ''.join(result)

def convert_bin_number_str_to_digit_number(bin_number_str):
    return chr(int(bin_number_str, 2))

n = int(input())
word = change_to_bit(input())
answer = []
for i in range(n):
    lt = i * 7
    rt = (i+1) * 7
    ch = convert_bin_number_str_to_digit_number(word[lt:rt])
    answer.append(ch)
print(''.join(answer), end='')
