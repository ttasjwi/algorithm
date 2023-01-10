class Solution:
    def reverseString(self, s) -> None:
        lt = 0
        rt = len(s) - 1
        while lt < rt:
            s[lt], s[rt] = s[rt], s[lt]
            lt += 1
            rt -= 1
