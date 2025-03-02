def solution(sequence, k):
    min_length = 1_000_001
    answer = [-1, -1]
    lt = 0
    rt = 0
    range_sum = sequence[0]

    while lt <= rt < len(sequence):
        if range_sum == k:
            length = rt - lt
            if length < min_length or (length == min_length and lt < answer[0]):
                answer[0] = lt
                answer[1] = rt
                min_length = length
            range_sum -= sequence[lt]
            lt += 1
            if rt < len(sequence) - 1:
                rt += 1
                range_sum += sequence[rt]
        elif range_sum < k:
            if rt < len(sequence) - 1:
                rt += 1
                range_sum += sequence[rt]
            else:
                break
        else:
            range_sum -= sequence[lt]
            lt += 1
    return answer
