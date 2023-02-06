from typing import List


class Solution:

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
