def solution(s):
    value = 0
    is_minus = False
    for ch in s:
        if ch == '+':
            pass
        elif ch == '-':
            is_minus = True
        else:
            value = value * 10 + (ord(ch) - 48)
    return -value if is_minus else value
