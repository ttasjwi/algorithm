class Solution:
    def longestPalindrome(self, s: str) -> str:
        def expand(lt: int, rt: int) -> str:  # 팰린드롬 판별 및 투포인터 확장
            while lt >= 0 and rt < len(s) and s[lt] == s[rt]:
                lt -= 1
                rt += 1
            return s[lt + 1:rt]  # 조건에 만족

        if len(s) <= 1 or s == s[::-1]:  # 문자열이 한 문자 이하 또는, 통채로 팰린드롬이면 그대로 반환
            return s
        result = ''
        for i in range(len(s) - 1):  # 슬라이딩 윈도우의 중심점을 이동시키면서
            result = max(result, expand(i, i), expand(i, i+1), key=len)  # 짝수 확장, 홀수 확장을 하면서, 최대 길이의 팰린드롬 문자열을 찾는다
        return result
