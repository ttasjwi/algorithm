def solution(my_string: str):
    my_string = my_string.replace(' ', '')
    answer = 0
    is_plus = True

    value = 0
    for ch in my_string:
        if ch.isnumeric():
            value = value * 10 + int(ch)
        else:
            answer += value if is_plus else -value
            value = 0
            if ch == '+':
                is_plus = True
            else:
                is_plus = False

    answer += value if is_plus else -value
    return answer
