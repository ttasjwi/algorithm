import sys

print = sys.stdout.write
input = sys.stdin.readline

input()
nums = sorted(map(int, input().split()))

def binary_search(num):
    lt = 0
    rt = len(nums) - 1
    while lt <= rt:
        mid = (lt + rt) >> 1
        if nums[mid] == num:
            return '1'
        elif nums[mid] < num:
            lt = mid + 1
        else:
            rt = mid - 1
    return '0'

input()
print('\n'.join(binary_search(num) for num in list(map(int, input().split()))))
