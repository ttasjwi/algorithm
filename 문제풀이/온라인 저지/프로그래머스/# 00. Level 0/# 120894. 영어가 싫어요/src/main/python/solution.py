def solution(numbers: str):
    for num, english in enumerate(['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']):
        numbers = numbers.replace(english, str(num))

    return int(numbers)

