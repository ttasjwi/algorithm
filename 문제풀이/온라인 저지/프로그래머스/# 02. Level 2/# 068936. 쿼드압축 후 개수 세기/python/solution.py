def solution(arr):
    answer = [0, 0]

    def compress(start_row, start_col, length):
        if length == 1:
            answer[arr[start_row][start_col]] += 1
            return arr[start_row][start_col]

        half = length // 2
        r1 = compress(start_row, start_col, half)
        r2 = compress(start_row, start_col + half, half)
        r3 = compress(start_row + half, start_col, half)
        r4 = compress(start_row + half, start_col + half, half)

        # 4개의 결과가 같으면 합쳐진 것으로 간주
        if r1 == r2 == r3 == r4 and r1 != -1:
            answer[r1] -= 3  # 개수가 중복으로 추가되었으므로 3개 빼줌
            return r1
        else:
            return -1  # 다른 값이 존재하므로 압축 불가

    compress(0, 0, len(arr))
    return answer
