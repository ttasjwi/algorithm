ch_arr = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F']

def solution(n, t, m, p):
    p -= 1 # (나머지 연산 편의를 위함. 0, 1, 2, ... m-1 순으로 따지기 쉽도록)
    cur_m = 0  # 현재 순서
    cur_t = 0  # 튜브가 몇 번째 말하는 지
    num = -1
    result = []
    while True:
        num += 1
        base_n_arr = get_base_n_arr(num, n)
        for ch in base_n_arr:
            if cur_m == p:
                cur_t += 1
                result.append(ch)
                if cur_t == t:
                    return ''.join(result)
            cur_m = (cur_m + 1) % m


def get_base_n_arr(num, n):
    if num == 0:
        return '0'
    result = []
    while num > 0:
        num, r = divmod(num, n)
        result.append(ch_arr[r])
    return ''.join(result[::-1])
