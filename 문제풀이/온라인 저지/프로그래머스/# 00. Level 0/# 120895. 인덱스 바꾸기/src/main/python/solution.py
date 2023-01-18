def solution(my_string, num1, num2):
    chars = list(my_string)
    chars[num1], chars[num2] = chars[num2], chars[num1]
    return ''.join(chars)
