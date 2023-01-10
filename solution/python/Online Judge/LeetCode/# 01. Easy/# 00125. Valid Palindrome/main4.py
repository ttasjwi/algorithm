import re


class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = s.lower()
        s = re.sub('[^a-z0-9]', '', s)  # 정규 표현식을 이용해, 소문자/숫자가 아닌 것들을 공백 문자로 치환
        return s == s[::-1]
   
