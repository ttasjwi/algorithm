# 문제
- 플랫폼 : LeetCode
- 번호 : 0009
- 제목 : Palindrome Number
- 난이도 : Easy
- 숫자를 뒤집었을 때 팰린드롬인 지 여부 판단하기
- 문제 : <a href="https://leetcode.com/problems/palindrome-number" target="_blank">링크</a>

---

# 필요 지식
- 문자열 처리
- 나머지 연산

---

# 풀이

## 풀이1: 문자열화하여 비교
```python
class Solution:
    def isPalindrome(self, x: int) -> bool:
        x = str(x)
        return x == x[::-1]
```
- 문자열로 변환하고 슬라이싱을 통해 비교하기
- 하지만 문제 조건에서 '문자열로 바꾸지 않고 풀 수 있는가?'라는 추가 조건이 있으므로 조건에 위배된다.
- 64ms 정도 소요된다.

## 풀이2: 나머지 연산
```python
class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0 or (x % 10 == 0 and x != 0):
            return False

        reversed_x = 0
        while x > reversed_x:
            reversed_x = reversed_x * 10 + x % 10
            x //= 10

        return x == reversed_x or x == reversed_x // 10
```
- 음수이거나, 오른쪽 끝이 0인데 시작이 0이 아닌 경우는 False 리턴
- 숫자를 10으로 나눠가면서 뒤집은 숫자를 구한다.
- 뒤집은 숫자와 원래 숫자가 완전히 같은 경우도 있지만(True), 자릿수가 홀수개인 경우 reversed_x에 숫자가 하나 더 붙는다. 이 숫자는 가운데 숫자이고
의미가 없으므로 10으로 다시 나눠 제거한다.
- 69ms 정도 소요된다.

---
