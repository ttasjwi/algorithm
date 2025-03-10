def solution(n, k):
    factorials = [0] * n
    factorials[0] = 1
    for i in range(1, n):
        factorials[i] = factorials[i - 1] * i
    nums = [i for i in range(1, n + 1)] # 1,2,3,...n
    answer = []

    while n > 0:
        idx = (k - 1) // factorials[n - 1] # 추출할 인덱스 계산
        answer.append(nums.pop(idx)) # 추출
        k %= factorials[n - 1] # k 를 (n-1)! 로 나눈 나머지만큼 k 는 남음
        n -= 1
    return answer
