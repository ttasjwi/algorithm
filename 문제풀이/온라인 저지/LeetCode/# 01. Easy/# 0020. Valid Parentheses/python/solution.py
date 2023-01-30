class Solution:
    def isValid(self, s: str) -> bool:
        pairs = {
            ')': '(',
            '}': '{',
            ']': '['
        }
        stack = []
        for ch in s:
            if ch not in pairs:
                stack.append(ch)
            elif not stack or pairs[ch] != stack.pop():
                return False

        return not stack

