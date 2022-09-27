# LeetCode 00125 : Valid Palindrome

- 난이도 : Easy
- 문자열을 뒤집었을 때 같은 문자열인지 확인
- 문제 : [링크](https://leetcode.com/problems/valid-palindrome/)

---

# 풀이

## 풀이1 : 리스트
```python
class Solution:
    def isPalindrome(self, s: str) -> bool:

        # 문자열을 리스트로 변환
        chars = []
        for char in s:
            if char.isalnum():  # 알파벳 또는 숫자니?
                chars.append(char.lower())  # 소문자화

        while len(chars) > 1:  # 1보다 길이가 길면
            if chars.pop(0) != chars.pop():  # 양쪽 끝을 pop하여 비교
                return False # 다른게 하나라도 있으면 거짓
        return True

```
- 문자열에서 문자를 하나 하나 추출, 필터링하여 리스트에 삽입한다.
- 리스트의 양끝에서 문자를 하나하나 뽑아가며 비교한다.
  - 리스트의 구조 특성상, 왼쪽 끝값을 제거하는 비용이 비싸다.
  - 그냥 양 끝의 인덱스(lt, rt)를 지정하고 이동시키면서 비교하는게 이득이다.

## 풀이2 : Deque
```python
import collections


class Solution:
    def isPalindrome(self, s: str) -> bool:

        # 문자열을 deque로 변환
        chars = collections.deque()
        for char in s:
            if char.isalnum():  # 알파벳 또는 숫자니?
                chars.append(char.lower())  # 소문자화

        while len(chars) > 1:  # 1보다 길이가 길면
            if chars.popleft() != chars.pop():  # 양쪽 양 끝을 pop하여 비교
                return False # 다른게 하나라도 있으면 거짓
        return True

```
- Deque를 사용한다. 양끝을 제거할 때 비용이 줄어든다.

## 풀이3 : 정규 표현식 + 투 포인터
```python
import re


class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = s.lower()
        s = re.sub('[^a-z0-9]', '', s)  # 정규 표현식을 이용해, 소문자/숫자가 아닌 것들을 공백 문자로 치환

        lt = 0
        rt = len(s) - 1

        while lt < rt:
            if s[lt] != s[rt]:
                return False
            lt += 1
            rt -= 1
        return True

```
- 정규 표현식을 이용해 문자열을 필터링한다.
  - `re.sub('정규표현식', '대체문자열', '문자열')`은, 정규표현식에 해당하는 문자열들을 대체시킨다.
  - 이를 이용해 빈 문자로 변환한다.
- lt, rt 양 끝을 이동시켜가면서 비교한다.

## 풀이4 : 정규 표현식 + 슬라이싱
```python
import re
class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = s.lower()
        s = re.sub('[^a-z0-9]', '', s)  # 정규 표현식을 이용해, 소문자/숫자가 아닌 것들을 공백 문자로 치환
        return s == s[::-1]
```
- 문자열 슬라이싱을 이용해 문자열을 뒤집어 복사할 수 있다.
- 파이썬의 문자열 슬라이싱은 내부적으로 매우 빠르게 진행되기 때문에, 슬라이싱을 사용하는 것이 가장 속도 개선에 유리하다.

## 풀이5 : C, C++ 등에서 포인터 사용
- 이 방법은 내가 C, C++ 을 배우지 않아서 아직 사용할 수 없다.

---
