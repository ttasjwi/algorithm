from math import sqrt


def solution(numbers):
    s = set()
    check = [False] * len(numbers)
    max_num = -1

    def dfs(idx, value):
        nonlocal max_num, check
        for i in range(len(numbers)):
            if idx == 0 and numbers[i] == '0':
                continue
            if not check[i]:
                check[i] = True
                next_value = value * 10 + ord(numbers[i]) - ord('0')
                if next_value > max_num:
                    max_num = next_value
                s.add(next_value)
                if idx != len(numbers) - 1:
                    dfs(idx + 1, next_value)
                check[i] = False

    dfs(0, 0)

    is_prime_number = [True] * (max_num + 1)
    is_prime_number[0], is_prime_number[1] = False, False
    if 1 in s:
        s.remove(1)
    for i in range(2, int(sqrt(max_num)) + 1):
        if is_prime_number[i]:
            for j in range(2 * i, max_num + 1, i):
                is_prime_number[j] = True
                if j in s:
                    s.remove(j)
    return len(s)
