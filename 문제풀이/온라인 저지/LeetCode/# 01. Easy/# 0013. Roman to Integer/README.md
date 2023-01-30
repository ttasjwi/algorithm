# 문제
- 플랫폼 : LeetCode
- 번호 : 0013
- 제목 : Roman to Integer
- 난이도 : Easy
- 로마문자의 규칙을 따라 주어진 문자열을 숫자로 변환하기
- 문제 : <a href="https://leetcode.com/problems/roman-to-integer" target="_blank">링크</a>

---

# 필요 지식
- 문자열 처리
- 해시

---

# 풀이

## 풀이1: 문자열 변환 후 딕셔너리 활용
```python
class Solution:
    def romanToInt(self, s: str) -> int:
        dict = {'I': 1, 'A': 4, 'V': 5, 'B': 9, 'X': 10, 'E': 40, 'L': 50, 'F': 90, 'C': 100, 'G': 400, 'D': 500,
                'H': 900, 'M': 1000}
        s = s.replace('IV', 'A') \
            .replace('IX', 'B') \
            .replace('XL', 'E') \
            .replace('XC', 'F') \
            .replace('CD', 'G') \
            .replace('CM', 'H')

        return sum([dict[ch] for ch in s])
```
- 4, 9, 40, 90, ... 처리가 까다로운 문제이다. III 와 같은 문자는 1 + 1 + 1 처리가 쉬운데 위의 숫자는 그와는 궤를 달리하기 때문이다.
- 그래서 나는 문제가 발생하는 IV, IX, XL, XC, CD, CM를 문제에서 주어주지 않은 문자로 변환하였다. 그리고 추가적인 문자도 딕셔너리에 넣었다.
- 변환한 한글자의 문자별로 딕셔너리에 있는 문자로 O(1)로 접근하고 숫자값으로 변환한다.
- 이들의 합을 반환하면 된다.
- 실행속도는 38 ms로 백분위 97.85%가 나왔다.

## 풀이2
```python
class Solution:
    def romanToInt(self, s: str) -> int:
        dict = {'I': 1, 'IV': 4, 'V': 5, 'IX': 9, 'X': 10, 'XL': 40, 'L': 50, 'XC': 90, 'C': 100, 'CD': 400, 'D': 500,
                'CM': 900, 'M': 1000}

        idx = 0
        answer = 0
        while idx < len(s):
            if s[idx:idx+2] in dict:
                answer += dict[s[idx:idx+2]]
                idx += 2
            else:
                answer += dict[s[idx]]
                idx += 1
        return answer
```
- while문으로 처음부터 순회하면서 2글자, 1글자 순으로 판단하는 방식

## 풀이3
```python
class Solution:
    def romanToInt(self, s: str) -> int:
        dict = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}

        prev = 1000
        answer = 0
        for ch in s:
            current = dict[ch]
            if prev < current:
                answer -= prev * 2
            answer += current
            prev = current
        return answer
```
- 문자열을 순서대로 비교하되, 전의 값보다 큰 값이 나왔을 경우 전의 값을 2번 차감하는 방식

---
