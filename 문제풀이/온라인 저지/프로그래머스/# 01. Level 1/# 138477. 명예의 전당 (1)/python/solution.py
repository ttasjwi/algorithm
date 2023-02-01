def solution(k, score):
    answer = []
    record = []
    for i in range(len(score)):
        if 0 <= i < k:
            record.append(score[i])
            record.sort()
        elif record[0] < score[i]:
            record[0] = score[i]
            record.sort()
        answer.append(record[0])
    return answer
