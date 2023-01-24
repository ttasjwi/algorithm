# 문제
- 플랫폼 : 프로그래머스
- 번호 : 068644
- 제목 : 두 개 뽑아서 더하기
- 난이도 : Level 1
- numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/68644" target="_blank">링크</a>

---

# 필요 지식
- 리스트 컴프리헨션
- combinations

---

# 풀이
```python
from itertools import combinations


def solution(numbers):
    return sorted(list({sum(comb) for comb in combinations(numbers, 2)}))
```
- `itertools.combinations` : 조합을 생성함
- 조합의 합들을 set에 저장
- list화
- 정렬

---
