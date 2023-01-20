def solution(num, total):
    lt = 0
    rt = num - 1
    current_sum = sum(i for i in range(lt, rt+1))

    while True:
        if current_sum == total:
            break

        elif current_sum > total:
            current_sum -= rt
            rt -= 1
            lt -= 1
            current_sum += lt

        else:
            current_sum -= lt
            lt += 1
            rt += 1
            current_sum += rt

    return [i for i in range(lt, rt + 1)]
