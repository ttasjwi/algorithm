import sys

print = sys.stdout.write
input = sys.stdin.readline

input()
nums = set(input().split())

input()
print('\n'.join('1' if item in nums else '0' for item in input().split()))
