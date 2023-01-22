# 문제
- 플랫폼 : 프로그래머스
- 번호 : 017681
- 제목 : [1차] 비밀지도
- 난이도 : Level 1
- 비밀지도의 암호를 해독하는 작업을 도와줄 프로그램을 작성
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/17681" target="_blank">링크</a>

---

# 필요 지식
- 비트연산
- bin 함수
- rjust 함수
- ...

---

# 풀이1 : 주어진 조건대로 변환
```python
def solution(n, arr1, arr2):
    return [get_password(a, b, n) for a, b in zip(arr1, arr2)]


def get_password(a, b, n):
    bit_a = convert_to_bit(a, n)
    bit_b = convert_to_bit(b, n)
    password = []

    for i in range(n):
        if '#' in (bit_a[i], bit_b[i]):
            code = '#'
        else:
            code = ' '
        password.append(code)

    return ''.join(password)


def convert_to_bit(number, n):
    strings = [' '] * n

    for i in range(-1, -n-1, -1):
        if number%2:
            strings[i] = '#'

        number //= 2

    return ''.join(strings)
```
- get_password : arr1, arr2의 각 요소를 읽고 이를 기반으로 패스워드 문자열로 변환한다.
- convert_to_bit : 하나의 숫자를 지도의 문자열로 변환한다.

# 풀이2 : bin 함수를 통한 이진 문자열화 활용
```python
from typing import List


def solution(n: int, arr1: List[int], arr2: List[int]):
    return [get_password(a, b, n) for a, b in zip(arr1, arr2)]


def get_password(a, b, n):
    password = bin(a | b)[2:]
    password = password.rjust(n, '0')  # 오른쪽 정렬(빈 자리는 '0'으로 변환)
    password = password.replace('0', ' ')  # '0'을 ' ' 으로 변환
    password = password.replace('1', '#')  # '1'을 '#' 으로 변환
    return password
```
- `a | b` : 두 숫자의 비트들에 대해 각각 or 연산
- `bin(...)` 함수 : 주어진 값에 대한 이진문자열 값을 반환한다.
  - 예) 10 -> bin(10) -> '0b1010'
- `문자열.rjust(n, ' '): n개의 자리수 및 빈 자리를 채울 문자를 지정하여 문자열을 오른쪽으로 정렬함
- replace 함수를 통해, '0'을 ' '으로 변환하고, '1'을 '#'으로 변환한다.

---
