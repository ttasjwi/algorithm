def solution(array, height):
    return sum(1 for item in array if item > height)
