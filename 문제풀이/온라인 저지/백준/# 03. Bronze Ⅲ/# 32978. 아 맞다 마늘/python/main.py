import sys

input = sys.stdin.readline

input()
print(({*input().split()} - {*input().split()}).pop())
