# 문제
- 플랫폼 : 프로그래머스
- 번호 : 042577
- 제목 : 전화번호 목록
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42577" target="_blank">링크</a>

---

# 필요 지식
- 해시

---

# 풀이
```python
def solution(phone_book):
    phone_set = set(phone_book)

    for phone in phone_book:
        for i in range(len(phone) - 1):
            if phone[:i + 1] in phone_set:
                return False
    return True
```
- phone_set 에 모든 번호를 삽입한다.
- phone_book 을 순회한다.
  - 전화번호 자기 자신이 아닌, 처음부터 시작하는 부분문자열들을 모두 phone_set 에서 조회한다.
  - 하나라도 존재하면 False 를 반환한다.
- 모든 단어에 대해서, 자기 자신이 아닌 시작부터 시작하는 부분문자열을 단 하나도 찾지 못 했다면 True 를 반환한다.

---
