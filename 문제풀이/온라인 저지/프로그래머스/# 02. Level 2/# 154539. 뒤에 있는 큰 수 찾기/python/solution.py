def solution(numbers):
    stack = []
    result = [-1] * len(numbers)
    # 역방향 반복
    for i in range(len(numbers)-1, -1, -1):
        # 스택에 요소가 있고, 스택의 마지막 요소가 현재 값보다 작거나 같으면 가치가 없으므로 전부 버림
        while stack and stack[-1] <= numbers[i]:
            stack.pop()

        # 스택에 요소가 남아있다면, 스택에 남아있는 수는 가장 가까운 가장 큰 수가 됨
        if stack:
            result[i] = stack[-1]
        # 스택에 현재 값을 삽입
        stack.append(numbers[i])
    return result
