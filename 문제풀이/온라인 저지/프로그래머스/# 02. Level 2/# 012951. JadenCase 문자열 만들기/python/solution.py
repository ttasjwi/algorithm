def solution(s: str):
    chars = list(s)

    for i, ch in enumerate(chars):
        if i - 1 == -1 or chars[i - 1] == ' ':
            chars[i] = ch.upper()
        else:
            chars[i] = ch.lower()

    return ''.join(chars)
