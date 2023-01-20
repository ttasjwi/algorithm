# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012903
- 제목 : 가운데 글자 가져오기
- 난이도 : Level 1
- 단어 s의 가운데 글자를 반환(단어의 길이가 짝수라면 가운데 두글자를 반환)
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12903" target="_blank">링크</a>

---

# 필요 지식
- 문자열 처리

---

# 풀이
```python
def solution(s):
    return s[(len(s)-1)//2:(len(s)+2)//2]
```
- 문자열 슬라이싱을 통해 문자를 자른다.
- 홀짝에 관계 없이 구조적으로 동일한 식을 만들려면 몫을 사용한 연산이 효율적인데, 이 숫자 장난이 약간 까다롭다.

---
