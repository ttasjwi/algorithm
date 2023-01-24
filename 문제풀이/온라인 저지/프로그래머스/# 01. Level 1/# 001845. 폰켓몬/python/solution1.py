from collections import Counter


def solution(nums):
    count = 0

    for key, value in Counter(nums).items():
        if value > 0:
            count += 1

        if count == len(nums)//2:
            return count

    return count
