def solution(n: int):
    string = ''
    while n > 0:
        string += str(n % 3)
        n //= 3

    return int(string, 3)

