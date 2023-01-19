def solution(my_string: str):
    return sum(int(i) for i in my_string.replace(' - ', ' + -').split(' + '))

