# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012926
- 제목 : 시저 암호
- 난이도 : Level 1
- 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12926" target="_blank">링크</a>

---

# 필요 지식
- 파이썬의 아스키 코드 처리
  - `ord('문자')`는 해당 문자의 아스키 코드 번호를 변환한다.
    - 예) `ord('0')` -> 48
  - `chr(아스키코드)`는 해당 아스키 코드를 문자로 변환한다.
    - 예) `chr(48)` -> '0'

---

# 풀이1
```python
def solution(s: str, n: int):
    chars = []

    for ch in s:
        if ch.isupper():
            chars.append(chr(ord('A') + (ord(ch) - ord('A')+ n) % 26))
        elif ch.islower():
            chars.append(chr(ord('a') + (ord(ch) - ord('a')+ n) % 26))
        else:
            chars.append(' ')

    return ''.join(chars)
```
- 공백이면 그냥 공백 삽입
- 대문자면 해당 문자의 아스키 코드에서 'A' 아스키 코드 값을 빼고, n을 더한 값을 26으로 나눈 나머지만큼을 'A' 기준으로 이동시킨 문자 삽입
- 소문자면 해당 문자의 아스키 코드에서 'a' 아스키 코드 값을 빼고, n을 더한 값을 26으로 나눈 나머지만큼을 'a' 기준으로 이동시킨 문자 삽입

# 풀이2
```python
def solution(s: str, n: int):
    chars = []
    uppers = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ' * 2
    lowers = 'abcdefghijklmnopqrstuvwxyz' * 2

    for ch in s:
        if ch.isupper():
            chars.append(uppers[uppers.index(ch) + n])
        elif ch.islower():
            chars.append(lowers[lowers.index(ch) + n])
        else:
            chars.append(' ')

    return ''.join(chars)
```
- 문제에서 주어진 n의 범위가 1~25이다.
- 알파벳 문자열모음을 2배화해서 준비해두고, 인덱스를 찾아 +n 위치에 있는 문자를 그대로 반환해도 된다.

---
