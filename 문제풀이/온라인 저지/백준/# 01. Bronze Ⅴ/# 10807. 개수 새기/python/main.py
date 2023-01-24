_ = input()
numbers = list(map(int, input().split()))
v = int(input())

answer = numbers.count(v)
print(answer, end='')
