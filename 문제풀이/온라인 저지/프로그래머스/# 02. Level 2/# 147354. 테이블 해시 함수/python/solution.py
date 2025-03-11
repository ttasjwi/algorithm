def solution(data, col, row_begin, row_end):
    data.sort(key=lambda t: (t[col - 1], -t[0]))  # col 번째 = col-1 번 인덱스

    # row_begin -1 행(인덱스)부터 row_end -1 행(인덱스)까지
    # 각 칼럼을 i+1(인덱스 + 1 = x번째)값으로 나눈 값의 합을 순서대로 리스트화
    sums = [sum(map(lambda x: x % (i + 1), data[i])) for i in range(row_begin - 1, row_end)]

    answer = 0
    for value in sums:
        answer ^= value  # xor 연산
    return answer
