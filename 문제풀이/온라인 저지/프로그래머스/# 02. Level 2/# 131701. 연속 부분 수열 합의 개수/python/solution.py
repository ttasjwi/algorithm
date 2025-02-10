def solution(elements):
    sum_set = set()
    for lt in range(len(elements)):
        rt = lt
        sum = 0
        while True:
            sum += elements[rt]
            sum_set.add(sum)

            rt = (rt + 1)%len(elements)
            if lt == rt:
                break
    return len(sum_set)
