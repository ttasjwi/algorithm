# 문제
- 플랫폼 : 프로그래머스
- 번호 : 068936
- 제목 : 쿼드압축 후 개수 세기
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/68936" target="_blank">링크</a>

---

# 필요 지식
- 분할 정복

---

# 풀이
```python
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
```
- 배열 전체를 순회하고 같지 않으면 다시 사등분해서 재귀하는 방식은 중복 탐색을 하는 문제가 발생한다.
- 먼저 재귀적으로 사등분한 뒤, 사등분 영역이 모두 같으면 합쳐나가는 식으로 처리하면 중복 탐색을 하지 않게 된다.

---
