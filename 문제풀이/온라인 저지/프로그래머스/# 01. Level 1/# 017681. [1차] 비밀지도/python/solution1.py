def solution(n, arr1, arr2):
    return [get_password(a, b, n) for a, b in zip(arr1, arr2)]


def get_password(a, b, n):
    bit_a = convert_to_bit(a, n)
    bit_b = convert_to_bit(b, n)
    password = []

    for i in range(n):
        if '#' in (bit_a[i], bit_b[i]):
            code = '#'
        else:
            code = ' '
        password.append(code)

    return ''.join(password)


def convert_to_bit(number, n):
    strings = [' '] * n

    for i in range(-1, -n-1, -1):
        if number%2:
            strings[i] = '#'

        number //= 2

    return ''.join(strings)
