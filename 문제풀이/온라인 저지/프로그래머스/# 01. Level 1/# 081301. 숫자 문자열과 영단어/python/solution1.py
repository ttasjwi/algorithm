def solution(s: str):
    results = []
    word_dict = {
        'zero': '0',
        'one': '1',
        'two': '2',
        'three': '3',
        'four': '4',
        'five': '5',
        'six': '6',
        'seven': '7',
        'eight': '8',
        'nine': '9'
    }

    lt, rt = 0, 0

    while lt <= rt and lt < len(s):
        current = s[lt:rt+1]

        if current.isnumeric():
            results.append(str(current))
            lt = rt+1
            rt = rt+1

        elif current in word_dict:
            results.append(word_dict[current])
            lt = rt+1
            rt = rt+1

        else:
            rt += 1

    return int(''.join(results))
