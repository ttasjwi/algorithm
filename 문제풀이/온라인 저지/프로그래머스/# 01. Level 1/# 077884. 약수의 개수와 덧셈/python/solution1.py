def solution(left, right):
    counts = [0, 1, *([2]*(right-1))]

    for i in range(2, right + 1):
        for j in range(2 * i, right + 1, i):
            counts[j] += 1

    return sum(i if counts[i] % 2 == 0 else -i
               for i in range(left, right + 1))

