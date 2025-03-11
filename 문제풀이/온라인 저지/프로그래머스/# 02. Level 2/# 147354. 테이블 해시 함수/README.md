# 문제
- 플랫폼 : 프로그래머스
- 번호 : 147354
- 제목 : 테이블 해시 함수
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/147354" target="_blank">링크</a>

---

# 필요 지식
- 정렬
- 구현

---

# 풀이
```python
def solution(data, col, row_begin, row_end):
    data.sort(key= lambda t: (t[col -1], -t[0])) # col 번째 = col-1 번 인덱스

    # row_begin -1 행(인덱스)부터 row_end -1 행(인덱스)까지
    # 각 칼럼을 i+1(인덱스 + 1 = x번째)값으로 나눈 값의 합을 순서대로 리스트화
    sums = [sum(map(lambda x: x%(i+1), data[i])) for i in range(row_begin - 1, row_end)] 
    
    answer = 0
    for value in sums:
        answer ^= value # xor 연산
    return answer
```
- 문제에서 시키는 대로 하면 되긴 하는데, 문제에서 말하는 x번째 행이라는 용어와, 실제 구현 과정에서 사용하는 인덱스의 개념이
다르기 때문에 혼동이 크다.
- 이런 문제를 대응하기 위해서는 주석을 통해 x 번째라는 용어를 알기 쉬운 용어로 변환하는 것이 중요할 듯 하다.

---
