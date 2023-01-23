# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012915
- 제목 : 문자열 내 마음대로 정렬하기
- 난이도 : Level 1
- 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하기
  - 해당 인덱스의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/12915)

---

# 필요 지식
- Python 정렬

---

# 풀이
```python
def solution(strings, n):
    return sorted(strings, key=lambda x: (x[n], x))
```
