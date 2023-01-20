# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012948
- 제목 : 핸드폰 번호 가리기
- 난이도 : Level 1
- 전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12948" target="_blank">링크</a>

---

# 필요 지식
- 문자열 처리

---

# 풀이
```python
def solution(phone_number):
    return '*'*(len(phone_number)-4) + phone_number[-4:]
```
- 전체 길이에서 4를 뺸 갯수만큼 별을 앞에 붙인다.
- 맨 뒤 4개는 그대로 붙인다.

---
