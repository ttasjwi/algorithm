def solution(food):

    result = [str(idx + 1) * (number//2) for idx, number in enumerate(food[1:])] + ['0']
    result += result[-2::-1]
    return ''.join(result)

