# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012941
- 제목 : 최솟값 만들기
- 난이도 : Level 2
- 두 배열의 임의의 두 요소를 곱한 값들의 합이 최소가 되도록 만들기(한번 곱한 값은 다시 사용하지 않음)
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12941" target="_blank">링크</a>

---

# 필요 지식
- 정렬

---

# 풀이
```python
def solution(A,B):
    # 오름차순 / 내림차순 정렬
    A.sort()
    B.sort(reverse=True)

    # 모두 합하기
    sum = 0
    for i in range(len(A)):
        sum += A[i] * B[i]
    return sum
```
```python
# zip 함수를 사용한 표현
def solution(a, b):
    return sum([x * y for x, y in zip(sorted(a), sorted(b, reverse=True))])
```
- 한쪽은 내림차순, 한쪽은 오름차순으로 정렬하고 순서대로 곱한다.

---
