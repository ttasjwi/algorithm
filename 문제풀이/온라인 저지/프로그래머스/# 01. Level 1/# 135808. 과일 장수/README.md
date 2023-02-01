# 문제
- 플랫폼 : 프로그래머스
- 번호 : 135808
- 제목 : 과일 장수
- 난이도 : Level 1
- 과일 장수가 얻을 수 있는 최대 이익 구하기
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/135808" target="_blank">링크</a>

---

# 필요 지식
- 그리디 알고리즘
- 정렬, 나머지 연산

---

# 풀이
```python
def solution(k, m, scores):
    return sum(sorted(scores)[len(scores) % m::m]) * m
```
- 결국 가격이 비싼 것들부터 끼리끼리 묶어서 순서대로 판매하는 것이 가장 큰 이익이다.
- 리스트를 정렬한다.
- 길이를 m으로 나눈 나머지 인덱스부터, m씩 증가하면서 해당 값을 더하고 m만큼 곱하면 된다.

---
