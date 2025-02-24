from collections import deque

def solution(x, y, n):
    if x == y:
        return 0

    check = [False] * (y + 1)
    funcs = [lambda x: x + n, lambda x: x * 2, lambda x: x * 3]
    check[x] = True
    answer = -1
    queue = deque([x])

    while queue:
        answer += 1
        for _ in range(len(queue)):
            cur_num = queue.popleft()

            for func in funcs:
                next_num = func(cur_num)
                if next_num == y:
                    return answer + 1
                elif next_num < y and not check[next_num]:
                    check[next_num] = True
                    queue.append(next_num)
    return -1
