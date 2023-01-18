# LeetCode 00344 : Reverse String
- 난이도 : Easy
- 리스트를 공간 복잡도 1로 뒤집기
- 문제 : [링크](https://leetcode.com/problems/reverse-string/)

---

# 풀이

## 풀이1 : 투 포인터
```python
class Solution:
    def reverseString(self, s) -> None:
        lt = 0
        rt = len(s) - 1
        while lt < rt:
            s[lt], s[rt] = s[rt], s[lt]
            lt += 1
            rt -= 1

```
- 양 끝 포인터를 통해, 조정해가면서 뒤집기

## 풀이2 : 파이썬 리스트 - reverse 함수
```python
from typing import List

class Solution:
    def reverseString(self, s:List[str]) -> None:
        s.reverse()
```
- 파이썬의 리스트 `reverse()` 함수를 이용하는 방법이 있다.

## 풀이3 : 슬라이싱
```python
from typing import List


class Solution:
    def reverseString(self, s: List[str]) -> None:
        s[:] = s[::-1]

```
- `s = s[::1]`로 리스트를 뒤집을 수 있긴 한데, 이 방법은 공간복잡도 `O(1)` 제약 사항이 있어서 불가능하다.
- 위와 같은 트릭을 사용하면 가능하긴 하다.

---
