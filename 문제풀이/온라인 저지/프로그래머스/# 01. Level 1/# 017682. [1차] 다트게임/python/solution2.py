sdt = {'S': 1, 'D': 2, 'T': 3}


def solution(dartResult: str):
    units = split_to_units(dartResult)
    return calculate_sum(units)


def split_to_units(dartResult):
    return ['10' if ch == 'x' else ch for ch in dartResult.replace('10', 'x')]


def calculate_sum(units):
    scores = [0]
    for unit in units:
        if unit in sdt:
            scores[-1] **= sdt[unit]
        elif unit == '*':
            scores[-1] *= 2
            scores[-2] *= 2
        elif unit == '#':
            scores[-1] *= -1
        else:
            scores.append(int(unit))
    return sum(scores[1:])
