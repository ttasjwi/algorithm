def solution(d, budget):
    d.sort()
    count = 0

    for value in d:
        if budget - value < 0:
            break
        else:
            budget -= value
            count += 1

    return count
