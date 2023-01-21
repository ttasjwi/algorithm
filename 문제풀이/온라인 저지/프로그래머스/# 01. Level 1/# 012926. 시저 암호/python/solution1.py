def solution(s: str, n: int):
    chars = []

    for ch in s:
        if ch.isupper():
            chars.append(chr(ord('A') + (ord(ch) + n) % 26))
        elif ch.islower():
            chars.append(chr(ord('a') + (ord(ch) + n) % 26))
        else:
            chars.append(' ')

    return ''.join(chars)
