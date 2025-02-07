def solution(s):
    result = []
    is_before_char_space = True
    for i in range(len(s)):
        if s[i].isspace():
            is_before_char_space = True
            result.append(s[i])
        else:
            if is_before_char_space:
                result.append(s[i].upper())
                is_before_char_space = False
            else:
                result.append(s[i].lower())
    return ''.join(result)
