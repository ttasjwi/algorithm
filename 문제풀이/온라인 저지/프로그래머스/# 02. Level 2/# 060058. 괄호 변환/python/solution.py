def solution(p):
    if p == '':
        return p
    u, v = split(p)
    if is_right(u):
        return u + solution(v)
    else:
        return f'({solution(v)}){reverse(u[1:-1])}'

def split(w):
    open = 0
    close = 0
    for i, ch in enumerate(w):
        if ch == '(':
            open += 1
        else:
            close += 1
        if open == close:
            return w[0:i + 1], w[i + 1:]

def reverse(s):
    result = []
    for ch in s:
        if ch == '(':
            result.append(')')
        else:
            result.append('(')
    return ''.join(result)

def is_right(s):
    stack = []

    for ch in s:
        if ch == '(':
            stack.append('(')
        else:
            if not stack:
                return False
            stack.pop()
    return not stack
