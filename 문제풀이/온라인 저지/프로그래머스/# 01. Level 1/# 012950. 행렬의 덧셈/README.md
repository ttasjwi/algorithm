# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012950
- 제목 : 행렬의 덧셈
- 난이도 : Level 1
- 2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12950" target="_blank">링크</a>

---

# 필요 지식
- Python : zip 활용

---

# 풀이
```python
def solution(arr1, arr2):
    return [[a + b for a, b in zip(x, y)] for x, y in zip(arr1, arr2)]
```
- zip으로 내부 1차원 배열을 엮는다.
- 다시 또 반복적으로 그 1차원 배열의 요소를 zip으로 엮어서, 합산한다.
- 이렇게 하면 2차원 배열의 덧셈이 구현된다.

---
