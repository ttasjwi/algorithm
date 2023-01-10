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
