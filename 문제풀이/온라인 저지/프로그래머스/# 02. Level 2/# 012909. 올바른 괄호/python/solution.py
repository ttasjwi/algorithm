def solution(s):
    stack = []
    for ch in s:
        if ch == '(':
            stack.append(ch)
        elif not stack or stack[-1] == ch:
            return False
        else:
            stack.pop()
    return False if stack else True
