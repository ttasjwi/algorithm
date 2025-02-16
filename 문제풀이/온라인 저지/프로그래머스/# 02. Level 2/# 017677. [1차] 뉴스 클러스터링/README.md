# 문제
- 플랫폼 : 프로그래머스
- 번호 : 017677
- 제목 : \[1차\] 뉴스 클러스터링
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/17677" target="_blank">링크</a>

---

# 필요 지식
- 해시
- 문자열 처리

---

# 풀이
```python
from collections import Counter


def solution(str1, str2):
    str1, str2 = str1.lower(), str2.lower()
    counter1 = Counter([str1[i:i + 2] for i in range(len(str1) - 1) if str1[i].isalpha() and str1[i + 1].isalpha()])
    counter2 = Counter([str2[i:i + 2] for i in range(len(str2) - 1) if str2[i].isalpha() and str2[i + 1].isalpha()])

    intersection_size = sum([v for v in (counter1 & counter2).values()])
    union_size = sum([v for v in (counter1 | counter2).values()])

    j = intersection_size / union_size if union_size else 1
    return int(j * 65536)
```
- 문자열 소문자화
- 문자열을 2연속 문자단위로 끊어가면서 확인해서 두 문자가 모두 알파벳인지 확인 후 배열에 삽입
- 배열 요소들을 Counter 를 통해 카운팅
- 교집합, 합집합 갯수를 구함.
- 합집합 크기가 0이면 j 값을 1로 하고, 아닐 경우 (교집합/합집합) 값을 구함.
- j 값에 65536 을 곱한 뒤 정수화

---
