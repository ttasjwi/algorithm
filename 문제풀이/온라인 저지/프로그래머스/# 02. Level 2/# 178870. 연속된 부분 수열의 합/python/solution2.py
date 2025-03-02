def solution(sequence, k):
    sums = [0] * len(sequence)
    sums[0] = sequence[0]
    for i in range(1, len(sequence)):
        sums[i] = sums[i - 1] + sequence[i]

    min_length = 1_000_001
    answer = [-1, -1]

    for start in range(len(sequence)):
        lt = start
        rt = len(sequence) - 1
        end = -1
        while lt <= rt:
            mid = (lt + rt) >> 1
            current_sum = sums[mid] - sums[start] + sequence[start]
            if current_sum == k:
                end = mid
                break
            elif current_sum > k:
                rt = mid - 1
            else:
                lt = mid + 1
        if end != -1:
            length = end - start
            if length < min_length or (length == min_length and start < answer[0]):
                answer[0] = start
                answer[1] = end
                min_length = length
    return answer
