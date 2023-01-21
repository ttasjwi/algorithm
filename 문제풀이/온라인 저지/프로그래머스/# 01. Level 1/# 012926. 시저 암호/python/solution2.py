def solution(s: str, n: int):
    chars = []
    uppers = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ' * 2
    lowers = 'abcdefghijklmnopqrstuvwxyz' * 2

    for ch in s:
        if ch.isupper():
            chars.append(uppers[uppers.index(ch) + n])
        elif ch.islower():
            chars.append(lowers[lowers.index(ch) + n])
        else:
            chars.append(' ')

    return ''.join(chars)
