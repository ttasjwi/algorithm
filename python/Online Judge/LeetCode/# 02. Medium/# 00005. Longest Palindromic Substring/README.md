# LeetCode 00005 : Longest Palindromic Substring
- 난이도 : Medium
- 문자열에서 가장 긴 팰린드롬 부분 문자열을 찾아 반환
- 문제 : [링크](https://leetcode.com/problems/group-anagrams/)

---

## 풀이

### expand(...)
```python
s = '...'

def expand(lt: int, rt: int) -> str:  # 팰린드롬 판별 및 투포인터 확장
    while lt >= 0 and rt < len(s) and s[lt] == s[rt]:
        lt -= 1
        rt += 1
    return s[lt + 1:rt]  # 조건에 만족
```
- 슬라이딩 윈도우를 이용한 팰린드롬 확인 함수이다.
- 만약 범위의 문자열이 팰린드롬이면, 슬라이딩 윈도우를 양 옆으로 확장한다.
- 팰린드롬이 아니면, lt+1(이전 lt값)부터 rt-1(이전 rt)까지의 문자열을 슬라이싱하여 반환한다.

```python
class Solution:
    def longestPalindrome(self, s: str) -> str:
        if len(s) <= 1 or s == s[::-1]:  # 문자열이 한 문자 이하 또는, 통채로 팰린드롬이면 그대로 반환
            return s
        result = ''
        for i in range(len(s) - 1):  # 슬라이딩 윈도우의 중심점을 이동시키면서
            result = max(result, expand(i, i), expand(i, i + 1), key=len)  # 홀수 확장, 짝수 확장을 하면서, 최대 길이의 팰린드롬 문자열을 찾는다
        return result
```
- 입력된 문자열이 한글자 또는, 통채로 팰린드롬이면 바로 문자열을 그대로 반환한다.
- 그렇지 않을 경우, 짝수 윈도우와 홀수 윈도우를 순차적으로 이동시키면서 가장 긴 팰린드롬을 갱신한다.

---
