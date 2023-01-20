# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012910
- 제목 : 나누어 떨어지는 숫자 배열
- 난이도 : Level 1
- element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12910" target="_blank">링크</a>

---

# 필요 지식
- 리스트 처리

---

# 풀이
```python
def solution(arr, divisor):
    arr = [i for i in arr if i % divisor == 0]
    return sorted(arr) if arr else [-1]
```
- 나누어 떨어지는 것만 남긴다.
- arr에 요소가 하나라도 있으면, 정렬해서 반환하고, 없으면 그냥 `[-1]`을 반환한다.

---
