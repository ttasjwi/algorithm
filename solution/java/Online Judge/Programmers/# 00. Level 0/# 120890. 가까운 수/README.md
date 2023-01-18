# 문제
- 번호 : 120890
- 제목 : 가까운 수
- 난이도 : Level 0
- array에 들어있는 정수 중 n과 가장 가까운 수를 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120890)

---

# 필요 알고리즘
- 정렬
  - 자바로도 풀 수 있긴한데, 정렬기준을 지정하기 위해 Comparator를 구현해야하고, 기본형을 박싱/언박싱하는 과정이 필요하다.
  - 코테 준비 관점에서는 코드의 간결성 면에서 이런 문제는 Python으로 빨리 푸는게 낫다.

---

# Python
```python
def solution(array, n):
    return min(array, key=lambda x: (abs(n-x), x-n))
```
- min 함수를 통해 다음 기준에 따른 최솟값을 구한다.
  - 첫번째 정렬 기준 : n과 x의 차의 최솟값
  - 두번째 정렬 기준 : x-n (차가 같을 경우 x-n 값이 작을 수록 더 작다)

---
