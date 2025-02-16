def solution(numbers, target):
    answer = 0

    def dfs(idx, cur):
        nonlocal answer
        if idx == len(numbers):
            if cur == target:
                answer += 1
            return
        dfs(idx + 1, cur + numbers[idx])
        dfs(idx + 1, cur - numbers[idx])

    dfs(0, 0)
    return answer
