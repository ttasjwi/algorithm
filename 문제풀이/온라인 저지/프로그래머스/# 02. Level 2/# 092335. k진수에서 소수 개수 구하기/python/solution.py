from math import sqrt

def solution(n, k):
    return len([num for num in split_numbers(n, k) if is_prime_number(num)])


# n진법 변환 후, 0이 아닌 숫자들 분리
def split_numbers(n, k):
    stack = [] # First In Last Out
    while n > 0:
        n, r = divmod(n, k)
        stack.append(r)
    cur = 0
    result = []
    while stack:
        head = stack.pop()
        if head != 0:
            cur *= 10
            cur += head
        elif cur != 0:
            result.append(cur)
            cur = 0
    if cur != 0:
        result.append(cur)
    return result


# 소수 여부 확인
def is_prime_number(n):
    if n == 1:
        return False
    for i in range(2, int(sqrt(n)) + 1):
        if n % i == 0:
            return False
    return True
