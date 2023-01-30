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
