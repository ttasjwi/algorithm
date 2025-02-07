# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012911
- 제목 : 다음 큰 숫자
- 난이도 : Level 2
- 주어진 숫자보다 크면서, 2진수의 비트 숫자가 같은 최소의 정수를 찾아 반환하기
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12911" target="_blank">링크</a>

---

# 필요 지식
- 문자열

---

# 풀이
```python
def solution(n):
    target_bit_count = bin(n).count('1')
    while True:
        n += 1
        if bin(n).count('1') == target_bit_count:
            return n
```
- `bin(n)` 함수를 통해 비트 문자열을 얻어오고 1의 갯수를 센다.
- n 을 계속 증가시켜가면서 비트 문자열의 1 갯수를 계속 세고 이 갯수가 일치하는 지 확인한다.

---
