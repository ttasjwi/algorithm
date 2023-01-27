# 문제
- 플랫폼 : 프로그래머스
- 번호 : 134240
- 제목 : 푸드 파이트 대회
- 난이도 : Level 1
- 수웅이가 준비한 음식의 양을 칼로리가 적은 순서대로 나타내는 정수 배열 food가 주어졌을 때, 대회를 위한 음식의 배치를 나타내는 문자열 반환
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/134240" target="_blank">링크</a>

---

# 필요 지식
- 문자열 처리

---

# 풀이
```python
def solution(food):

    result = [str(idx + 1) * (number//2) for idx, number in enumerate(food[1:])] + ['0']
    result += result[-2::-1]
    return ''.join(result)
```
- 1번 인덱스부터 순서대로 지정 갯수만큼 문자열 결합
- 0을 붙인다
- -2번 인덱스부터 순서대로 역으로 붙인다.

---
