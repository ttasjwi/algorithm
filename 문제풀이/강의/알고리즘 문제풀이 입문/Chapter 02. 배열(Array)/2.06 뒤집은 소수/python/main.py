from math import sqrt

input()
nums = [int(s[::-1]) for s in input().split()]
max_number = max(nums) # 입력값 중 제일 큰수 구하기

# 에라토스테네스의 체 사용 -> 소수 찾기
is_prime = [False, False] + [True] * (max_number - 1)
for i in range(2, int(sqrt(max_number)) + 1):
    if is_prime[i]:
        for j in range(2 * i, max_number + 1, i):
            is_prime[j] = False

# 입력 받아서, 뒤집고, 소수이면 result에 담기
result = []
for num in input().split():
    num = int(num[::-1])
    if is_prime[num]:
        result.append(num)

# 출력
print(*result, end='', sep=' ')
