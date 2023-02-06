# 문제
- 플랫폼 : LeetCode
- 번호 : 0017
- 제목 : Letter Combinations of a Phone Number
- 난이도 : Medium
- 2부터 9까지 숫자가 주어졌을 때 전화번호로 조합 가능한 모든 문자 출력
- 문제 : <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number" target="_blank">링크</a>

---

# 필요 지식
- DFS(깊이 우선 탐색)
- itertools.product

---

# 풀이
## 풀이1
```python
def letterCombinations(self, digits: str) -> List[str]:
    if not digits:
        return []

    chars = {'2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl', '6': 'mno', '7': 'pqrs', '8': 'tuv', '9': 'wxyz'}
    answer = []

    def dfs(k, word):
        if k == len(digits):
            answer.append(word)
            return
        for ch in chars[digits[k]]:
            dfs(k + 1, word + ch)

    dfs(0, '')
    return answer
```
- dfs를 통해 인덱스를 1씩 증가하면서 단어를 만들어나간다.


## 풀이2
```python
def letterCombinations(self, digits: str) -> List[str]:
    if not digits:
        return []
    chars = {'2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl', '6': 'mno', '7': 'pqrs', '8': 'tuv', '9': 'wxyz'}
    groups = [chars[digit] for digit in digits]
    return [''.join(prod) for prod in product(*groups)]
```
- itertools.product를 사용

---
