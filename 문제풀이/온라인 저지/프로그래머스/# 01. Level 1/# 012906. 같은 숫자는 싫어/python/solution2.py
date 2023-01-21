def solution(arr):
    stack = []
    for value in arr:
        if (not stack) or (stack[-1] != value):
            stack.append(value)

    return stack
