def solution(n: int):
    nums = []
    while n > 0:
        nums.append(n % 3)
        n //= 3

    return sum(value * (3 ** idx) for idx, value in enumerate(nums[::-1]))


