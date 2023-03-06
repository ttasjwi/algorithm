n = int(input())


def find_sqrt():
    lt = 1
    rt = n
    while lt <= rt:
        mid = (lt + rt) // 2
        x = mid ** 2
        if x == n:
            return mid
        elif x < n:
            lt = mid + 1
        else:
            rt = mid - 1


print(find_sqrt())
