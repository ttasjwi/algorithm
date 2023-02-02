# 문제
- 플랫폼 : 프로그래머스
- 번호 : 131128
- 제목 : 숫자 짝꿍
- 난이도 : Level 1
- 두 정수 X, Y가 주어졌을 때 공통으로 나타나는 정수 k(0 ≤ k ≤ 9)들(중복 허용)을 이용하여 만들 수 있는 가장 큰 정수 반환
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/131128" target="_blank">링크</a>

---

# 필요 지식
- 문자열 처리
- Python : Counter

---

# 풀이
```python
from collections import Counter


def solution(x, y):
    c = Counter(str(x)) & Counter(str(y))
    return '-1' if not c else '0' if len(c) == 1 and '0' in c else ''.join(sorted(c.elements(), reverse=True))
```
- 문자열 x, y의 카운터에 대해 '&' 연산으로 공통된 요소들의 카운터를 얻는다.
- 만약 카운터가 비어있다면 공통된 요소가 없으므로 '-1'을 반환
- 카운터의 길이가 1인데, 요소가 '0'뿐이면 '0' 반환
- 그 외의 경우에는 `.elements()`로 요소들을 얻어온 뒤, 내림차순으로 정렬하고, join으로 결합하여 반환한다.

---
